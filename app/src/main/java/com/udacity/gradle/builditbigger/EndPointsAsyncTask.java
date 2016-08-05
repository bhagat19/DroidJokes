package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.amit.androidlibrary.DroidJokesActivity;
import com.example.amit.droidjokes.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by amit on 01-08-2016.
 */
public class EndPointsAsyncTask extends AsyncTask<Pair<Context, TextView>, Void, String> {

    private static MyApi myApiService = null;
    private Context context;
    private TextView view;

    public EndPointsAsyncTask(Context context) {
        context = context.getApplicationContext();
    }

    @Override
    protected String doInBackground(Pair<Context, TextView>... params) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("https://droidjokes-1470141500268.appspot.com/_ah/api/");
            // options for running against local devappserver
            // - 10.0.2.2 is localhost's IP address in Android emulator
            // - turn off compression when running against local devappserver

            // end options for devappserver

            myApiService = builder.build();
        }

        context = params[0].first;
        view = (TextView) params[0].second;

        //Calling GCE API

        try {
            return myApiService.getJoke("joke").execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    //   @Override
    //  protected void

    @Override
    protected void onPostExecute(String result) {
        if (result != null) {
            view.setText(result);

            Intent intent = new Intent(context, DroidJokesActivity.class);
            intent.putExtra("joke", result);
            context.startActivity(intent);

            //  Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        }
    }
}


