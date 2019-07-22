package com.example.android.go2gether;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.List;

/**
 * Created by saad on 2/7/2019.
 */

public class ShareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);


        //facebook
        (findViewById(R.id.face)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText( ShareActivity.this,"sharing", Toast.LENGTH_SHORT).show();
                Intent fb = new Intent(Intent.ACTION_SEND);
                fb.setType("text/plain");
                List<ResolveInfo> matches = getPackageManager().queryIntentActivities(fb, 0);
                for (ResolveInfo info : matches) {
                    if (info.activityInfo.packageName.toLowerCase().startsWith("com.facebook.katana")) {
                        fb.setPackage(info.activityInfo.packageName);
                        break;
                    } else {
                        fb.setPackage("com.facbook.lite");
                    }
                }
                fb.putExtra(Intent.EXTRA_TITLE, "Go2Gether");
                try {
                    startActivity(fb);
                } catch (android.content.ActivityNotFoundException e) {
                    Toast.makeText( ShareActivity.this,e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        //whatsapp
        (findViewById(R.id.whats)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText( ShareActivity.this,"sharing", Toast.LENGTH_SHORT).show();
                Intent wt = new Intent(Intent.ACTION_SEND);
                wt.setType("text/plain");
                wt.setPackage("com.whatsapp");
                wt.putExtra(Intent.EXTRA_TITLE, "Go2Gether");
                try {
                    startActivity(wt);
                } catch (android.content.ActivityNotFoundException e) {
                    Toast.makeText( ShareActivity.this,e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        //twitter
        (findViewById(R.id.tweet)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] pkg = {"hgh", "hg"};
                Toast.makeText( ShareActivity.this,"sharing", Toast.LENGTH_SHORT).show();
                Intent tw = new Intent(Intent.ACTION_SEND);
                tw.setType("text/plain");
                tw.setPackage("com.twitter.android");
                tw.putExtra(Intent.EXTRA_TITLE, "Go2Gether");
                try {
                    startActivity(tw);
                } catch (android.content.ActivityNotFoundException e) {
                    Toast.makeText( ShareActivity.this,e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        //more share
        (findViewById(R.id.more)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "Go2Gether");
                i.putExtra(Intent.EXTRA_TEXT, "يمكنك اختصار الوقت والمال باستخدامك هذا التطبيق");
                startActivity(Intent.createChooser(i, "choose app"));

            }
        });



    }
}


































