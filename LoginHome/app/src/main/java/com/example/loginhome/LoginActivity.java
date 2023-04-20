package com.example.loginhome;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private Button btn_Login;
    private EditText et_Username,et_Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn_Login = (Button) findViewById(R.id.button_login);
        et_Username = (EditText) findViewById(R.id.et_username);
        et_Password = (EditText) findViewById(R.id.et_password);
        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = et_Username.getText().toString();
                String password = et_Password.getText().toString();
                 if (username.equals("Username") && password.equals("Password")){
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getApplicationContext(),"Try again with 'Username' and 'Password'",Toast.LENGTH_SHORT).show();
            }
        });
    }
}