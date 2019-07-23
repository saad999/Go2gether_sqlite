package com.example.android.go2gether;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Try extends AppCompatActivity {

    //final EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try);

        //editText=findViewById(R.id.editText999);
        button =findViewById(R.id.btn_cc99);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(Try.this, editText.getText().toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
