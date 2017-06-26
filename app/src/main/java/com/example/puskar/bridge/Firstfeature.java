package com.example.puskar.bridge;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Firstfeature extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstfeature);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);

    }
    public void onehnclick(View v){
        if (v.getId()== R.id.emergencyhelpnotices){
            Intent i= new Intent(Firstfeature.this,wallpage.class);
            startActivity(i);
        }
    }
    public void onshnclick(View v){
        if (v.getId()== R.id.simplehelpnotices){
            Intent i= new Intent(Firstfeature.this,wallpage2.class);
            startActivity(i);
        }
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
