package com.wordpress.pratikparmarsite.task1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et;
    Button b;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        try {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            startService(new Intent(MainActivity.this, MyService.class));
            et = (EditText) findViewById(R.id.editText);
            b = (Button) findViewById(R.id.button);
            tv = (TextView) findViewById(R.id.textView);
        }
        catch(Exception e)
        {
            System.out.println("Error");
        }

    }

    public void getData(View view)
    {
              String name=et.getText().toString();
               tv.setText(name);
    }

    public void clear(View view)
    {
        et.setText(null);
    }

}
