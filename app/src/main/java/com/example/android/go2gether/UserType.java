package com.example.android.go2gether;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class UserType extends AppCompatActivity {

    final String PREFS_NAME = "FirstShow";
    SharedPreferences settings;
    public static String userType = null;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        this.getWindow().setStatusBarColor(getResources().getColor(R.color.yellow_orange));
        setContentView(R.layout.activity_user_type);

        settings = getSharedPreferences(PREFS_NAME, 0);

    }

    public void openClientTutorial(View view) {
        userType = "client";
        if (settings.getBoolean("my_first_time_client", true)) {
            //the app is being launched for first time, do something
            Intent intent = new Intent(this, tutorialClientActivity_1.class);
            startActivity(intent);
            Log.d("Comments", "First time");
            // first time task
            // record the fact that the app has been started at least once
            settings.edit().putBoolean("my_first_time_client", false).apply();
        } else {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

    }

    public void openDriverTutorial(View view) {
        userType = "driver";
        if (settings.getBoolean("my_first_time_driver", true)) {
            //the app is being launched for first time, do something
            Intent intent = new Intent(this, tutorialDriverActivity_1.class);
            startActivity(intent);
            Log.d("Comments", "First time");
            // first time task
            // record the fact that the app has been started at least once
            settings.edit().putBoolean("my_first_time_driver", false).apply();
        } else {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }


    }
}
