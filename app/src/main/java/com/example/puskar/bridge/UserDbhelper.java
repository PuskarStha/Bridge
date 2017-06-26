package com.example.puskar.bridge;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by puskar on 5/20/2017.
 */

public class UserDbhelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "bridge.db";
        private static final int DATABASE_VERSION = 1;
        private static final String CREATE_QUERY=
                "CREATE TABLE "+ UserContract.Newuserinfo.DATA_TABLE+"("+ UserContract.Newuserinfo.COLUMN_NAME+" text not null,"
                        + UserContract.Newuserinfo.COLUMN_CONTACT+" TEXT,"
                        + UserContract.Newuserinfo.COLUMN_ADDRESS+" TEXT,"
                        + UserContract.Newuserinfo.COLUMN_MESSAGE+" text not null);";

        public UserDbhelper(Context context)
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
            contentValues.put(UserContract.Newuserinfo.COLUMN_NAME,username);
            contentValues.put(UserContract.Newuserinfo.COLUMN_CONTACT,usercontact);
            contentValues.put(UserContract.Newuserinfo.COLUMN_ADDRESS,useraddress);
            contentValues.put(UserContract.Newuserinfo.COLUMN_MESSAGE,usermessage);
            db.insert(UserContract.Newuserinfo.DATA_TABLE,null,contentValues);
            Log.e("DATABASE OPERATIONS","one row is inserted....");
        }
        public Cursor getInformation(SQLiteDatabase db){
            Cursor cursor;
            String[]projections ={UserContract.Newuserinfo.COLUMN_NAME , UserContract.Newuserinfo.COLUMN_CONTACT , UserContract.Newuserinfo.COLUMN_ADDRESS
                    ,UserContract.Newuserinfo.COLUMN_MESSAGE };
            cursor= db.query(UserContract.Newuserinfo.DATA_TABLE,projections,null,null,null,null,null);
            return cursor;
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }

