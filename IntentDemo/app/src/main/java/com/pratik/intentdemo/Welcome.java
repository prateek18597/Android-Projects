package com.pratik.intentdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by pratik on 13/9/17.
 */

public class Welcome extends Activity {

    TextView txt;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        Intent i=getIntent();
        String k=i.getStringExtra("ap");
        txt=(TextView)findViewById(R.id.txt);
        txt.setText(k);
    }


}
