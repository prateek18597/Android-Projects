package com.pratik.intentdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn2;
    EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button)findViewById(R.id.button);
        btn2=(Button)findViewById(R.id.button1);
        name=(EditText) findViewById(R.id.textView1);



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s1=name.getText().toString().trim();
                String welcome="Welcome "+s1;

                Intent i=new Intent(MainActivity.this,Welcome.class);
                i.putExtra("ap",welcome);
                startActivity(i);

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s1=name.getText().toString().trim();
                String welcome="Welcome "+s1;

                Intent i=new Intent("send.welcome.intent");
                i.putExtra("ap",welcome);
                startActivity(i);

            }
        });

    }
}
