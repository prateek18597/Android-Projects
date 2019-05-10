package com.pratik.asynctask;

import android.app.IntentService;
import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity
{

    Button button;
    TextView finalResult;
    EditText time;


            @Override
            protected void onCreate(Bundle savedInstanceState)
            {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);

                time=(EditText)findViewById(R.id.ip_time);
                button=(Button)findViewById(R.id.btn_run);
                finalResult=(TextView)findViewById(R.id.tv_result);

                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                            new AsyncTaskRunner().execute(time.getText().toString().trim());

                            }
                        });
            }


            private class AsyncTaskRunner extends AsyncTask<String,String,String>
            {
                    String resp;
                    ProgressDialog progressDialog;

                    @Override
                    protected String doInBackground(String... strings)
                    {
                        publishProgress("Sleeping...");//Calls onProgressUpdates()
                        try
                        {
                               int time= Integer.parseInt(strings[0])*1000;
                                Thread.sleep(time);
                                resp="Slept for "+strings[0]+ " seconds";
                        }
                        catch(InterruptedException e)
                        {
                            e.printStackTrace();
                            resp=e.getMessage();
                            //return resp;

                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                            resp=e.getMessage();
                            //return resp;
                        }
                        return resp;
                    }

                    @Override
                    protected void onPostExecute(String result) {
                        //super.onPostExecute(result);
                        progressDialog.dismiss();
                        finalResult.setText(result);
                    }

                @Override
                protected void onPreExecute() {
                    //super.onPostExecute(result);
                    progressDialog=ProgressDialog.show(MainActivity.this,"Progress Dialog","Wait for "+ time.getText().toString().trim());
                }

                @Override
                protected  void onProgressUpdate(String... text)
                {
                    finalResult.setText(text[0]);
                    //things to do while expression of long running operations is in progress
                }


            }


}
