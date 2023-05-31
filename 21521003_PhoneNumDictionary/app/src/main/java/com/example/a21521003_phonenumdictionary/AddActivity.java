package com.example.a21521003_phonenumdictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {
    EditText et_firstname, et_phonenum, et_lastname;
    Button btn_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        et_firstname = (EditText) findViewById(R.id.edt_fistname);
        et_lastname = (EditText) findViewById(R.id.edt_lastname);
        et_phonenum = (EditText) findViewById(R.id.edt_phonenum);
        btn_save = (Button) findViewById(R.id.btn_save);


        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
                intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

                intent
                        .putExtra(ContactsContract.Intents.Insert.PHONE, et_phonenum.getText())
                        .putExtra(ContactsContract.Intents.Insert.PHONE_TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_WORK)
                        .putExtra(ContactsContract.Intents.Insert.NAME, et_firstname.getText() + " " + et_lastname.getText())
                ;
                startActivity(intent);
                finish();
            }
        });
    }
}