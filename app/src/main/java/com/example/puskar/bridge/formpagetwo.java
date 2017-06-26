package com.example.puskar.bridge;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class formpagetwo extends AppCompatActivity {
    EditText Username1, usercontact1,useraddress1,usermessage1;
    Context context= this;
    UserDbhelper1 userDbHelper1;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formpagetwo);
       Username1 = (EditText) findViewById(R.id.name1);
        usercontact1= (EditText) findViewById(R.id.contact1);
        useraddress1= (EditText) findViewById(R.id.address1);
        usermessage1= (EditText) findViewById(R.id.description1);
        Username1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (Username1.getText().length()==0){
                    Username1.setError("name field must not be left empty");
                }
            }
        });
        usermessage1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (usermessage1.getText().length()==0){
                    usermessage1.setError("message field must not be left empty");
                }
            }
        });
    }
    public void button_msg(View view) {
        if (Username1.getText().length() > 0 && usermessage1.getText().length() > 5 )
        {
            if ( usercontact1.getText().length()==7 || usercontact1.getText().length()==10){
            String Name = Username1.getText().toString();
            String Contact = usercontact1.getText().toString();
            String Address = useraddress1.getText().toString();
            String Message = usermessage1.getText().toString();
            userDbHelper1 = new UserDbhelper1(context);
            sqLiteDatabase = userDbHelper1.getWritableDatabase();
            userDbHelper1.addInformation(Name, Contact, Address, Message, sqLiteDatabase);
            Toast.makeText(getBaseContext(), "Your post has been posted", Toast.LENGTH_LONG).show();
            userDbHelper1.close();
            Intent intent = new Intent(formpagetwo.this, wallpage2.class);
            startActivity(intent);
            }
            else
            {Toast.makeText(getBaseContext(), "Number must be of seven or ten digits", Toast.LENGTH_LONG).show();}
        }
        else
        {Toast.makeText(getBaseContext(), "You may have left some necessary field empty", Toast.LENGTH_LONG).show();}
    }

}
