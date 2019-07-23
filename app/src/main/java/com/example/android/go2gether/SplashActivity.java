package com.example.android.go2gether;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.sp_anim);

        LayoutInflater layoutInflater=getLayoutInflater();
        View view =layoutInflater.inflate(R.layout.activity_splash,(ViewGroup) findViewById(R.id.sp));
        view.setAnimation(animation);
        Thread timer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(SplashActivity.this, RegisterClientActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
        timer.start();
    }

}