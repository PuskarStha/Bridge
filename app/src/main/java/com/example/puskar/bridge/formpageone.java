package com.example.puskar.bridge;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.attr.id;

public class formpageone extends AppCompatActivity {
    EditText Username, usercontact,useraddress,usermessage;
    Context context= this;
     UserDbhelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formpageone);
         Username = (EditText) findViewById(R.id.name);
         usercontact= (EditText) findViewById(R.id.contact);
        useraddress= (EditText) findViewById(R.id.address);
        usermessage= (EditText) findViewById(R.id.description);

        Username.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (Username.getText().length()==0){
                    Username.setError("name field must not be left empty");
                }
            }
        });

        usermessage.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (usermessage.getText().length()==0){
                    usermessage.setError("message field must not be left empty");
                }
            }
        });


    }
   /* public void button_msg(View view){
        Toast.makeText(getApplicationContext(),"Your post has been posted",Toast.LENGTH_LONG).show();
    }*/

    public void button_msg(View view) {
        if (Username.getText().length()>0 && usermessage.getText().length()>5  )
        {
            if ( usercontact.getText().length()==7 || usercontact.getText().length()==10){

            String Name = Username.getText().toString();
            String Contact = usercontact.getText().toString();
            String Address = useraddress.getText().toString();
            String Message = usermessage.getText().toString();
            userDbHelper = new UserDbhelper(context);
            sqLiteDatabase = userDbHelper.getWritableDatabase();
            userDbHelper.addInformation(Name, Contact, Address, Message, sqLiteDatabase);
            Toast.makeText(getBaseContext(), "Your post has been posted", Toast.LENGTH_LONG).show();
            userDbHelper.close();
            Intent intent = new Intent(formpageone.this, wallpage.class);
            startActivity(intent);}
            else
            {Toast.makeText(getBaseContext(), "Number must be of seven or ten digits", Toast.LENGTH_LONG).show();}
        }
        else{
            Toast.makeText(getBaseContext(), "You may have left some neccessary field empty", Toast.LENGTH_LONG).show();
        }
    }
}
