package com.example.android.go2gether;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class RegisterClientActivity extends AppCompatActivity {

    EditText editTextN,editTextEm,editTextC,editTextPH,editTextG,editTextP;
    //DataBase dataBase =new DataBase(this);
    ImageView imageView,imageViewbig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_client);

        editTextN=(EditText) findViewById(R.id.editText);
        editTextEm=(EditText)findViewById(R.id.editText2);
        editTextC=findViewById(R.id.editText3);
        editTextPH=findViewById(R.id.editText5);
        editTextG=findViewById(R.id.editText7);
        editTextP=findViewById(R.id.editText9);
        imageView=findViewById(R.id.imageView7);
        imageViewbig=findViewById(R.id.imageView6);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ContextCompat.checkSelfPermission(RegisterClientActivity.this, Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED){
                    Intent intent =new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent,123);
                }else {
                    ActivityCompat.requestPermissions(RegisterClientActivity.this,new String[]{Manifest.permission.CAMERA},12);
                }
            }
        });


        findViewById(R.id.btn_su).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final DataBase dataBase =new DataBase(getApplicationContext());

                if(editTextN.getText().toString().isEmpty()){editTextN.setError("Empty!");}
                if(editTextEm.getText().toString().isEmpty()){editTextEm.setError("Empty!"); }
                if(editTextC.getText().toString().isEmpty()){editTextC.setError("Empty!"); }
                if(editTextG.getText().toString().isEmpty()){editTextG.setError("Empty!");}
                if(editTextG.getText().toString().isEmpty()){editTextG.setError("\"male\" or \"female\"");}
                if(editTextP.getText().toString().isEmpty()){editTextP.setError("at least 6 char");}
               //if(editTextEm.getText().toString().matches("(.*)@(.*)")){editTextEm.setError("unvailed!");}
                if(!dataBase.chkEmail(editTextEm.getText().toString())){editTextEm.setError("already found!");}

                else {
                    boolean ins = dataBase.addOne(editTextEm.getText().toString()
                            , editTextN.getText().toString()
                            , editTextC.getText().toString()
                            , editTextPH.getText().toString()
                            , editTextG.getText().toString()
                            , editTextP.getText().toString());

//                    Toast.makeText(RegisterClientActivity.this, editTextC.getText().toString(), Toast.LENGTH_SHORT).show();


                    if (ins) {
                        Toast.makeText(RegisterClientActivity.this, "success", Toast.LENGTH_SHORT).show();


                    } else
                        Toast.makeText(RegisterClientActivity.this, "no!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        findViewById(R.id.btn_cc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DataBase dataBase =new DataBase(getApplicationContext());
                Toast.makeText(RegisterClientActivity.this, "show", Toast.LENGTH_SHORT).show();

                AlertDialog.Builder builder =new AlertDialog.Builder(RegisterClientActivity.this);
                builder.create().setCancelable(true);
                builder.setTitle("Data").setMessage(dataBase.getall());
                builder.show();


            }
        });
        }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==12){
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(RegisterClientActivity.this, "PERMISSION GRANTED", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(RegisterClientActivity.this, "PERMISSION REQUIRED", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode==123&&resultCode== Activity.RESULT_OK){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imageViewbig.setImageBitmap(bitmap);
        }
    }
}
