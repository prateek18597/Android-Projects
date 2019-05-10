package com.pratik.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    Button addbtn,showbtn,submit,count;
    DBHandler db;
     EditText name,number;
    LinearLayout contactForm;
    ListView contactList;
    TextView empty;
    LinearLayout showContact;
    List<Contact> contacts;
    List<String> namelist;
    String[] nameArray;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
//        startActivity(new Intent(MainActivity.this,Contact.class));

    }

    private void init()
    {
        addbtn=(Button)findViewById(R.id.add);
        showbtn=(Button)findViewById(R.id.show);
        count=(Button)findViewById(R.id.count);

        db=new DBHandler(MainActivity.this);
        submit=(Button)findViewById(R.id.submit);
        name=(EditText)findViewById(R.id.input_name);
        number=(EditText)findViewById(R.id.input_number);
        empty=(TextView)findViewById(R.id.empty);
        contactForm=(LinearLayout)findViewById(R.id.contact_form);
        showContact=(LinearLayout)findViewById(R.id.show_contact);

        onButtonClick();
        //contactForm=(LinearLayout)findViewById()
    }

    private void onButtonClick() {

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showContact.setVisibility(View.GONE);
                contactForm.setVisibility(View.VISIBLE);

            }
        });

        showbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showContact.setVisibility(View.VISIBLE);
                contactForm.setVisibility(View.GONE);
                contacts=db.getAllContactList();
                if(contacts.size()==0)
                {
                    contactList.setVisibility(View.GONE);
                    empty.setVisibility(View.VISIBLE);
                    empty.setText("No contacts.");
                }
                else
                {
                    empty.setVisibility(View.GONE);
                    contactList.setVisibility(View.VISIBLE);
                    namelist=new ArrayList<String>();
                    for(Contact cn:contacts)
                    {
                        namelist.add(cn.getName());


                    }
                    nameArray=namelist.toArray(new String[namelist.size()]);
                    adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,android.R.id.text1,nameArray);
                    contactList.setAdapter(adapter);
                }

            }
        });

        count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                contactForm.setVisibility(View.GONE);
                showContact.setVisibility(View.VISIBLE);
                contactList.setVisibility(View.GONE);
                empty.setVisibility(View.VISIBLE);

                empty.setText(db.getContactCount()+ " Contacts");

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    //Toast.makeText(MainActivity.this, "Contact inserted Successfully", Toast.LENGTH_LONG).show();
                    //Contact temp = new Contact();
                    String na = (name.getText().toString().trim());
                    String phone = number.getText().toString().trim();

                    if (na=="") {
                        name.setError("Enter Name");
                    } else {
                        if (phone=="") {
                            number.setError("Enter Phone Number");
                        } else {
                            Contact temp = new Contact(na, phone);
                            db.addContact(temp);
                            name.setText(null);
                            number.setText(null);

                            Toast.makeText(MainActivity.this, "Contact inserted Successfully", Toast.LENGTH_SHORT).show();
                        }

                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        });
    }
}
