package com.pratik.jsonandroid;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by pratik on 20/9/17.
 */

public class PostActivity extends Activity implements View.OnClickListener {

    EditText editName, editEmail, editMobile;
    Button submit;

    String name, email, mobile,rollnumber="49";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post);
        editName = (EditText) findViewById(R.id.editName);
        editEmail = (EditText) findViewById(R.id.editEmail);
        editMobile = (EditText) findViewById(R.id.editMobile);

        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view == submit) {

            registerContact();
        }
    }


    private void registerContact() {
        name = editName.getText().toString().trim();
        email = editEmail.getText().toString().trim();
        mobile = editMobile.getText().toString().trim();
        if(!isName(name))
        {
            editName.setError("Enter Name");
        }
        else if(!isEmail(email))
        {
            editEmail.setError("Enter Email");

        }
        else if (!isMobile((mobile)))
        {
            editMobile.setError("Enter Mobile");
        }
        else
        {
            new SendRequest().execute();
        }



    }

    public class  SendRequest extends AsyncTask<String,Void,String>
    {
        @Override
            protected String doInBackground(String... strings)
        {
            try
            {
                URL url=new URL("http://www.tech2sys.com/workshop/workshopApi.php?action=insertData");
                JSONObject postData=new JSONObject();
                postData.put("name",name);
                postData.put("email",email);
                postData.put("mobile",mobile);
                postData.put("rollNumber",rollnumber);

                HttpURLConnection con=(HttpURLConnection)url.openConnection();
                con.setRequestMethod("POST");

                OutputStream os=con.getOutputStream();
                BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
                writer.write(getPostData(postData));
                writer.flush();;
                writer.close();
                os.close();

                int responseCode=con.getResponseCode();

                if(responseCode==HttpURLConnection.HTTP_OK)
                {
                    BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
                    StringBuilder sb=new StringBuilder("");
                    String line="";
                    while((line=br.readLine())!=null)
                    {
                        sb.append(line);
                        //break;
                    }
                    br.close();
                    return sb.toString();
                }
                else
                    return new String("False: "+ responseCode);



            }
            catch(Exception e)
            {
                return new String("Exception: "+ e.getMessage());
            }
            //return null;
        }

        protected void onPostExecute(String result)
        {
            editName.setText("");
            editEmail.setText("");
            editMobile.setText("");

            Toast.makeText(PostActivity.this,result,Toast.LENGTH_LONG).show();;
        }
    }

    public String getPostData(JSONObject postData) throws Exception
    {

        StringBuilder sb=new StringBuilder();
        boolean first=true;
        Iterator<String> itr=postData.keys();

        while(itr.hasNext())
        {
            String key=itr.next();
            Object value= postData.get(key);
            if(first)
                first=false;
            else
                sb.append("&");
            sb.append(URLEncoder.encode(key,"UTF-8"));
            sb.append("=");
            sb.append(URLEncoder.encode(value.toString(),"UTF-8"));
        }
        return sb.toString();

    }


    public static boolean isName(String name)
    {
        String expression="^[a-zA-Z\\s]+";
        return name.matches(expression);

        //return na;
    }

    public static boolean isEmail(String email)
    {
        String expression="^[_a-zA-Z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z]{2,}$+)";
        //Pattern pattern= Pattern.compile(expression);
        //Matcher matcher=pattern.matcher(email);
        //return matcher.matches();

     return email.matches(expression);

        //return na;
    }

    public static boolean isMobile(String number)
    {
        String expression="^[789]\\d{9}$";
        return number.matches(expression);

        //return na;
    }
}
