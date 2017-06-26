package com.example.puskar.bridge.bridge;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.example.puskar.bridge.Login;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * Created by pradip on 5/9/2017.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contacts.db";
    private static final String TABLE_NAME = "contacts";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_UNAME = "uname";
    private static final String COLUMN_PASS = "pass";
    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table contacts (id integer primary key not null , " +
            "Uname text not null , pass text not null)";

    public DatabaseHelper(Context context)

    {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db=db;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query =" DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }

    public void insertContact(Contact c)
    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query= "select * from contacts";
        Cursor cursor =db.rawQuery(query, null);
        int count =cursor.getCount();

        values.put(COLUMN_ID,count);
        values.put(COLUMN_UNAME, c.getUname());
        values.put(COLUMN_PASS, c.getPass());
        db.insert(TABLE_NAME,null,values);
        db.close();
      //  cursor.close();
    }


    public String searchPass(String uname)
    {
        db = this.getReadableDatabase();
        String query = "select uname, pass from " + TABLE_NAME;
        Cursor cursor =db.rawQuery(query, null);
        String a, b;
        b="not found";
        if(cursor.moveToFirst())
        {
            do {
                a=cursor.getString(0);

                if(a.equals(uname))
                {
                    b=cursor.getString(1);
                    break;
                }
            }
            while (cursor.moveToNext());
        }
        //cursor.close();
        return b;
    }

 /*   public void copyDBToSDCard() {
        try {
            File sd = Environment.getExternalStorageDirectory();
            File data = Environment.getDataDirectory();

            if (sd.canWrite()) {
                String currentDBPath = "//data//"+getPackageName()+"//databases//"+DATABASE_NAME+"";
                String backupDBPath = "backupname.db";
                File currentDB = new File(data, currentDBPath);
                File backupDB = new File(sd, backupDBPath);

                if (currentDB.exists()) {
                    FileChannel src = new FileInputStream(currentDB).getChannel();
                    FileChannel dst = new FileOutputStream(backupDB).getChannel();
                    dst.transferFrom(src, 0, src.size());
                    src.close();
                    dst.close();
                }

            }
            Toast.makeText(com.bridge.newaccount.this,"Database Saved", Toast.LENGTH_LONG).show();
        }  catch (Exception e) {
            Toast.makeText(com.bridge.newaccount.this,"Error="+e, Toast.LENGTH_LONG).show();
            Log.i("FO","exception="+e);
        }


    }*/

    }
