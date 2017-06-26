package com.example.puskar.bridge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.puskar.bridge.Help;
import com.example.puskar.bridge.R;

public class Help extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
    }

    public void text1click(View view) {
        Intent next = new Intent(Help.this, text1.class);
        startActivity(next);
    }
    public void text2click(View view) {
        Intent next = new Intent(Help.this, text2.class);
        startActivity(next);
    }
    public void text3click(View view) {
        Intent next = new Intent(Help.this,text3.class);
        startActivity(next);
    }
}
