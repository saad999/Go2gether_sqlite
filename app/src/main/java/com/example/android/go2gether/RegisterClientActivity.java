package com.example.android.go2gether;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterClientActivity extends AppCompatActivity {

    EditText editTextN,editTextEm,editTextC,editTextPH,editTextG,editTextP;
    DataBase dataBase =new DataBase(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_client);

        editTextN=findViewById(R.id.editText);
        editTextEm=findViewById(R.id.editText2);
        editTextC=findViewById(R.id.editText3);
        editTextPH=findViewById(R.id.editText5);
        editTextG=findViewById(R.id.editText7);
        editTextP=findViewById(R.id.editText9);

        final String name  = editTextN.getText().toString();
        final String  email = editTextEm.getText().toString();
        final String country = editTextC.getText().toString();
        final String phone = editTextPH.getText().toString();
        final String gender = editTextG.getText().toString();
        final String pass = editTextP.getText().toString();


            findViewById(R.id.btn_su).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    DataBase dataBase =new DataBase(getApplicationContext());

                    /*if(name.isEmpty()){editTextN.setError("Empty!");}
                    if(email.isEmpty()){editTextEm.setError("Empty!"); }
                    if(country.isEmpty()){editTextC.setError("Empty!"); }
                    //if(!gender.isEmpty()){editTextG.setError("Empty!");}
                    if(!gender.equalsIgnoreCase("male")){editTextG.setError("\"male\" or \"female\"");}
                    if(!gender.equalsIgnoreCase("female")){editTextG.setError("\"male\" or \"female\"");}
                    if(pass.isEmpty()){editTextP.setError("at least 6 char");}
                    if(!email.matches("(.*)@(.*)")){editTextEm.setError("unvailed!");}
                    else if(!dataBase.chkEmail(email)){editTextEm.setError("already found!");}

                    else {*/
                        final Client client = new Client(name,email,country,phone,gender,pass);

                        dataBase.addOne(client);
                        SQLiteDatabase database1= dataBase.getReadableDatabase();
                        Cursor cursor =database1.rawQuery("select email from Client",null);

                        for (int i=0;i<2;i++){

                            if(i==0)


                    cursor.moveToFirst();
                        Toast.makeText(RegisterClientActivity.this,cursor.getString(0),Toast.LENGTH_SHORT).show();
                        //cursor.close();
                            cursor.moveToNext();
                        }
                    //}

                }
            });
        }

}
