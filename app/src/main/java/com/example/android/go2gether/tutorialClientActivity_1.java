package com.example.android.go2gether;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class tutorialClientActivity_1 extends AppCompatActivity {

    public static Activity context;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setStatusBarColor(getResources().getColor(R.color.yellow_orange));
        setContentView(R.layout.activity_tutorial_client_1);
        context = this;
    }

    public void skipButton(View view) {
        Intent intent = new Intent(this, ResetPasswordActivity.class);
        startActivity(intent);
        finish();
    }

    public void nextButton(View view) {
        Intent intent = new Intent(this, tutorialClientActivity_2.class);
        startActivity(intent);

    }
}