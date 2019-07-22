package com.example.android.go2gether;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class LoginActivity extends AppCompatActivity {
    String userType = UserType.userType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        finish_tutorial();
    }

    private void finish_tutorial() {
        try {
            if (userType.equalsIgnoreCase("driver")) {
                tutorialDriverActivity_1.context.finish();
                tutorialDriverActivity_2.context.finish();
                tutorialDriverActivity_3.context.finish();
            } else if (userType.equalsIgnoreCase("client")) {
                tutorialClientActivity_1.context.finish();
                tutorialClientActivity_2.context.finish();
                tutorialClientActivity_3.context.finish();

            }
        } catch (NullPointerException exption) {

        }
    }

    public void RestPassword(View view) {
        Intent intent = new Intent(this, ResetPasswordActivity.class);
        startActivity(intent);
    }

    public void Signup(View view) {
        if (userType.equalsIgnoreCase("driver")) {
            Intent intent = new Intent(this, RegisterDriverActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, RegisterClientActivity.class);
            startActivity(intent);
        }
    }
}
