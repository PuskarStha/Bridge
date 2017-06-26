package com.example.puskar.bridge;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.puskar.bridge.bridge.DatabaseHelper;
import com.example.puskar.bridge.R;

import static com.example.puskar.bridge.R.id.Password;
import static com.example.puskar.bridge.R.id.newaccount;
import static com.example.puskar.bridge.R.id.textView;
import static com.example.puskar.bridge.R.id.username;

public class Login extends AppCompatActivity {
    EditText NAme,password;
    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        NAme = (EditText) findViewById(R.id.namefield);
        password = (EditText) findViewById(R.id.passwordfield);
      /*  Name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (Name.getText().length()==0){
                    Name.setError("name field must not be left empty");
                }
            }
        });
        password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (password.getText().length()==0){
                    password.setError("message field must not be left empty");
                }
            }
        });*/


    }


    public void onButtonClick(View v){

    if (NAme.getText().length()>0)

        {
            //if (v.getId() == R.id.Login)
            // {
            EditText a = (EditText) findViewById(R.id.namefield);
            String str = a.getText().toString();
            EditText b = (EditText) findViewById(R.id.passwordfield);
            String pass = b.getText().toString();

            String password = helper.searchPass(str);

            if (pass.equals(password)) {
              /*  Intent btn = new Intent(Login.this, Home.class);
                startActivity(btn);*/
                Intent i = new Intent(Login.this, home.class);
                // i.putExtra("username",str);
                startActivity(i);
            } else {
                //popup message
                Toast temp = Toast.makeText(Login.this, "Username and Password don't Match!", Toast.LENGTH_SHORT);
                temp.show();
            }
            // }
        }
        else
        {
            Toast.makeText(getBaseContext(), "You cannot leave any field empty", Toast.LENGTH_LONG).show();
        }

    }




       /* Login = (Button) findViewById(R.id.Login);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                Intent btn = new Intent(Login.this, Home.class);
                startActivity(btn);
            }
        });*/



    public void clickExit(View v) {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
    public void registeraccount(View view) {
        Intent next = new Intent(Login.this, newaccount.class);
        startActivity(next);
    }
    public void clickHelp(View view) {
        if(view.getId()==R.id.help) {
            Intent i = new Intent(Login.this,Help.class);
            startActivity(i);
        }
    }
}

