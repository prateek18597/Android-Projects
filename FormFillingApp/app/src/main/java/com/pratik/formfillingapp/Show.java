package com.pratik.formfillingapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by pratik on 13/9/17.
 */

public class Show extends MainActivity {

    EditText n,a,g;
    static String x,y,z;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.show);
        n=(EditText)findViewById(R.id.namefield);
        a=(EditText)findViewById(R.id.agefield);
        g=(EditText)findViewById(R.id.genderfield);
        Intent i1=getIntent();

        String k=i1.getStringExtra("startname");

        x=k;
        String m=i1.getStringExtra("startage");
        y=m;
        String s=i1.getStringExtra("startgender");
        z=s;//g.setText(s);
        n.setText(x);
        a.setText(y);
        g.setText(z);
    }

    public static void main(String args[])
    {


    }
}
