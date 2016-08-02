package com.example.amit.androidlibrary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * Created by amit on 30-07-2016.
 */
public class DroidJokesActivity extends AppCompatActivity {

    public final String LOG_TAG = DroidJokesActivity.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState){
        //make a class
        //do this


        super.onCreate(savedInstanceState);
        setContentView(R.layout.jokesactivity_main);
        Intent intent = getIntent();
        Log.v(LOG_TAG,"joke from java lib via android lib"+intent.getStringExtra("joke"));

        Toast.makeText(this,intent.getStringExtra("joke"),Toast.LENGTH_SHORT).show();
    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
    */
}
