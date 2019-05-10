package com.pratik.sqlite;

/**
 * Created by pratik on 19/9/17.
 */

public class Contact {

    String name;
    int id;

    public Contact()
    {}



    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    String  phone_no;
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public  Contact(int i,String na,String ph)
    {
        id=i;
        name=na;
        phone_no=ph;
    }

    public  Contact(String na,String ph)
    {

        name=na;
        phone_no=ph;
    }



}
