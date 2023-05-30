package com.example.a21521003_todolist;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnsave;
    TextView title,des,date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnsave= (Button) findViewById(R.id.btn_Save);
        title = (EditText) findViewById(R.id.plt_title);
        des=(EditText) findViewById(R.id.mult_des);
        date=(EditText) findViewById(R.id.plt_date);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                intent.putExtra("newTodo_title", title.getText().toString());
                intent.putExtra("newTodo_des", des.getText().toString());
                intent.putExtra("newTodo_date", date.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });




    }

}