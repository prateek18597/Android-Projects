package com.pratik.jsonandroid;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by pratik on 20/9/17.
 */

public class GetActivity extends AppCompatActivity {

    ProgressDialog pDialog;
    ListView lv;
    ArrayList<HashMap<String,String>> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get);

        contactList=new ArrayList<>();
        lv=(ListView)findViewById(R.id.list);
        new GetData().execute();




    }

    private class GetData extends AsyncTask<String, Void,String>
    {
        @Override
        protected String doInBackground(String... strings) {

            HttpClient httpClient=new DefaultHttpClient();
            HttpGet httpGet=new HttpGet("http://www.tech2sys.com/workshop/workshopApi.php?action=getData");

            try
            {
                HttpResponse httpResponse=httpClient.execute(httpGet);
                InputStream is=httpResponse.getEntity().getContent();
                InputStreamReader inputStream= new InputStreamReader(is);
                BufferedReader br=new BufferedReader(inputStream);
                StringBuffer sb=new StringBuffer();

                String line;
                while((line=br.readLine())!=null)
                {
                    sb.append(line);
                    //sb.toString();
                }
                return sb.toString();
                //Reader();
            }
            catch(Exception e)
            {
                e.printStackTrace();
                return new String(e.getMessage());
            }



        }

        @Override
        protected void onPostExecute(String res)
        {
            if(res!=null)
            {
                try
                {
                    JSONObject jsonObj=new JSONObject(res);
                    JSONArray contacts=jsonObj.getJSONArray("result");

                    for(int i=0;i<contacts.length();i++)
                    {
                        JSONObject c=contacts.getJSONObject(i);
                        String rollNumber=c.getString("rollNumber");
                        String name=c.getString("name");
                        String mobile=c.getString("mobile");
                        String email=c.getString("email");

                        HashMap<String,String> contact=new HashMap<>();
                        contact.put("rollNumber",rollNumber);
                        contact.put("name",name);
                        contact.put("mobile",mobile);
                        contact.put("email",email);

                        contactList.add(contact);
                        ListAdapter adapter=new SimpleAdapter(GetActivity.this,contactList,R.layout.list_row,new String[]{"name","email","mobile","rollnumber"},
                                new int[]{R.id.name,R.id.email,R.id.mobile,R.id.roll});
                        lv.setAdapter(adapter);

                    }

                }
                catch(Exception e)
                {
                    e.printStackTrace();
                    Toast.makeText(GetActivity.this,"Exception ",Toast.LENGTH_LONG).show();
                }
            }
            else
            {
                Toast.makeText(GetActivity.this,"",Toast.LENGTH_SHORT).show();
            }
        }

    }


}
