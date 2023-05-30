package com.example.a21521003_phonenumdictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {
EditText et_name,et_phonenum;
Button btn_save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        et_name = (EditText) findViewById(R.id.edt_name);
        et_phonenum = (EditText) findViewById(R.id.edt_phonenum);
        btn_save = (Button) findViewById(R.id.btn_save);


        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddActivity.this,MainActivity.class);
                startActivity();
            }
        });
    }
}