package com.example.puskar.bridge;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.puskar.bridge.R;

public class home extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public void logoutbutton(View view) {
        Intent next = new Intent(home.this, Login.class);
        startActivity(next);

    }

    public void oneclick(View view) {
        if (view.getId() == R.id.notice) {
            Intent i = new Intent(home.this, Firstfeature.class);
            startActivity(i);
        }
    }
}