package com.pratik.sqlite;

/**
 * Created by pratik on 19/9/17.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class DBHandler extends SQLiteOpenHelper{

    public static final String databaseName="contact";

    public static final int databaseVersion=1;

    public static  final String table="Contact";

    public static final String KeyId="Id";
    public static final String KeyName="Name";
    public static final String KeyNumber="Number";

    SQLiteDatabase rs;

    public DBHandler(Context ct)
    {
        //SQLiteDatabase.CursorFactory cursorFactory,int
        super(ct,databaseName,null,databaseVersion);


    }

    @Override
    public void onCreate(SQLiteDatabase sql) {

        try {

            String query = "CREATE TABLE " + (table) + " (" + KeyId + " INTEGER PRIMARY KEY, " + KeyName + " TEXT ,'" + KeyNumber + "' INTEGER)";
            rs.execSQL(query);
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldver, int newver) {

        //databaseVersion++;
        String Drop="DROP TABLE IF EXISTS "+ table;
        rs.execSQL(Drop);
        onCreate(rs);

    }

    void addContact(Contact con)
    {
        rs=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        //cv.put(KeyId,con.getId());
        cv.put(KeyName,con.getName());
        cv.put(KeyNumber,con.getPhone_no());

        rs.insert(table,null,cv);
        rs.close();

    }

    public List<Contact> getAllContactList()
    {

        List<Contact> contactList =new ArrayList<>();
        String que="SELECT * FROM Contact";//+table;
        rs=this.getReadableDatabase();

        Cursor cursor=rs.rawQuery(que,null);
        if(cursor.moveToFirst()){
        do
        {
            Contact c=new Contact();
            c.setId(Integer.parseInt(cursor.getString(0)));
            c.setName((cursor.getString(1)));
            c.setPhone_no((cursor.getString(2)));
            contactList.add(c);
        }
        while(cursor.moveToNext());
        }


        return contactList;
    }


    public int updateContact(Contact contact)
    {
        rs=this.getWritableDatabase();
        ContentValues ct=new ContentValues();
        ct.put(KeyName,contact.getName());
        ct.put(KeyNumber,contact.getPhone_no());

        return rs.update(table,ct,KeyId+"=?",new String[]{String.valueOf(contact.getId())});
    }

    public void deleteContact(String id)
    {
        rs=this.getWritableDatabase();


        rs.delete(table,KeyId+"=?",new String[]{String.valueOf(id)});
        rs.close();
    }

    public int getContactCount()
    {
        rs=this.getReadableDatabase();
        String cursorquery="Select * from "+table;

        Cursor cursor=rs.rawQuery(cursorquery,null);
        return cursor.getCount();


    }


}
