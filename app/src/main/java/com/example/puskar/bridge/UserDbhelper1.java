package com.example.puskar.bridge;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by puskar on 5/21/2017.
 */

public class UserDbhelper1 extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "bridge1.db";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_QUERY=
            "CREATE TABLE "+ UserContract2.Newuserinfo1.DATA_TABLE1+"("+ UserContract2.Newuserinfo1.COLUMN_NAME+" text not null,"
                    + UserContract2.Newuserinfo1.COLUMN_CONTACT+" TEXT,"
                    + UserContract2.Newuserinfo1.COLUMN_ADDRESS+" TEXT,"
                    + UserContract2.Newuserinfo1.COLUMN_MESSAGE+" text not null);";

    public UserDbhelper1(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        Log.e("DATABASE OPERATIONS","Database created/opened....");
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATIONS","Table created....");
    }

    public void addInformation(String username, String usercontact, String useraddress, String usermessage, SQLiteDatabase db)
    {
        ContentValues contentValues = new ContentValues();
          /*  contentValues.put(UserContract.Newuserinfo.COLUMN_ID,id);*/
        contentValues.put(UserContract2.Newuserinfo1.COLUMN_NAME,username);
        contentValues.put(UserContract2.Newuserinfo1.COLUMN_CONTACT,usercontact);
        contentValues.put(UserContract2.Newuserinfo1.COLUMN_ADDRESS,useraddress);
        contentValues.put(UserContract2.Newuserinfo1.COLUMN_MESSAGE,usermessage);
        db.insert(UserContract2.Newuserinfo1.DATA_TABLE1,null,contentValues);
        Log.e("DATABASE OPERATIONS","one row is inserted....");
    }
    public Cursor getInformation(SQLiteDatabase db){
        Cursor cursor;
        String[]projections ={UserContract2.Newuserinfo1.COLUMN_NAME , UserContract2.Newuserinfo1.COLUMN_CONTACT , UserContract2.Newuserinfo1.COLUMN_ADDRESS
                ,UserContract2.Newuserinfo1.COLUMN_MESSAGE };
        cursor= db.query(UserContract2.Newuserinfo1.DATA_TABLE1,projections,null,null,null,null,null);
        return cursor;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
