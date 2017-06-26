package com.example.puskar.bridge;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class wallpage extends AppCompatActivity {
    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    UserDbhelper userDbhelper;
    Cursor cursor;
    ListDataAdapter listDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpage);
        listView = (ListView) findViewById(R.id.list_view);
        listDataAdapter = new ListDataAdapter(getApplicationContext(), R.layout.row_layout);
        listView.setAdapter(listDataAdapter);
        userDbhelper = new UserDbhelper(getApplicationContext());
        sqLiteDatabase = userDbhelper.getReadableDatabase();
        cursor = userDbhelper.getInformation(sqLiteDatabase);
        if (cursor.moveToFirst()) {
            do {
                String name, contact, address, message;
                name = cursor.getString(0);
                contact = cursor.getString(1);
                address = cursor.getString(2);
                message = cursor.getString(3);
                Dataprovider dataprovider = new Dataprovider(name, contact, address, message);
                listDataAdapter.add(dataprovider);

            } while (cursor.moveToNext());
        }
    }

    public void formpage(View v) {
        if (v.getId() == R.id.postemergency) {
            Intent i = new Intent(wallpage.this, formpageone.class);
            startActivity(i);
        }
    }

    public void backclick(View v) {
        if (v.getId() == R.id.imageButton) {
            Intent i = new Intent(wallpage.this, home.class);
            startActivity(i);
            finish();
        }
    }
}
