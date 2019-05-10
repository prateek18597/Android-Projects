package com.wordpress.pratikparmarsite.activitydemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.tview1);
        button =(Button)findViewById(R.id.b);
    }

    public void showDetails(View view)
    {
        TelephonyManager tm=(TelephonyManager)getBaseContext().getSystemService(Context.TELEPHONY_SERVICE);

        String android_id=tm.getDeviceId().toString();

        textView.setText(android_id);

    }

    public static void main(String args[])
    {

    }
}
