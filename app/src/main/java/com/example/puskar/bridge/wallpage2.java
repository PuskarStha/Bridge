package com.example.puskar.bridge;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class wallpage2 extends AppCompatActivity {
  ListView listView;
    SQLiteDatabase sqLiteDatabase;
    UserDbhelper1 userDbhelper1;
    Cursor cursor;
    ListDataAdapter listDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpage2);
        listView= (ListView)findViewById(R.id.list_view);
        listDataAdapter = new ListDataAdapter(getApplicationContext(),R.layout.row_layout);
        listView.setAdapter(listDataAdapter);
        userDbhelper1= new UserDbhelper1(getApplicationContext());
        sqLiteDatabase= userDbhelper1.getReadableDatabase();
        cursor = userDbhelper1.getInformation(sqLiteDatabase);
        if (cursor.moveToFirst())
        {
            do{
                String name,contact,address,message;
                name= cursor.getString(0);
                contact= cursor.getString(1);
                address= cursor.getString(2);
                message= cursor.getString(3);
                Dataprovider dataprovider = new Dataprovider(name,contact,address,message);
                listDataAdapter.add(dataprovider);

            }while(cursor.moveToNext());
        }

    }

    public void formpage2(View v) {
        if (v.getId() == R.id.postsimple) {
            Intent i = new Intent(wallpage2.this, formpagetwo.class);
            startActivity(i);
        }
    }
    public void backclick1(View v) {
        if (v.getId() == R.id.imageButton1) {
            Intent i = new Intent(wallpage2.this, home.class);
            startActivity(i);
            finish();
        }
    }

}
