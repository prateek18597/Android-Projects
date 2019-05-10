package com.pratik.formfillingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button b;
    EditText name,age,gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.name);
        age=(EditText)findViewById(R.id.age);
        gender=(EditText)findViewById(R.id.gender);
        b=(Button)findViewById(R.id.submit);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String myname=name.getText().toString().trim();
                String myage=(age.getText().toString().trim());
                String mygender=gender.getText().toString();

                if(mygender.equals("male"))
                {
                    myname="Mr."+myname
                            ;
                }
                else
                    myname="Ms."+myname;


                Intent intent1=new Intent("show.name");
                intent1.putExtra("startname",myname);
                intent1.putExtra("startage",myage);
                intent1.putExtra("startgender",mygender);
                startActivity(intent1);









            }
        });

    }


}
