package com.example.a21521003_sqlitehomework;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a21521003_sqlitehomework.db.ClassDbHelper;
import com.example.a21521003_sqlitehomework.db.StudentDbHelper;
import com.example.a21521003_sqlitehomework.entity.Class;
import com.example.a21521003_sqlitehomework.entity.Student;

public class MainActivity extends AppCompatActivity {
    EditText edt_cid, edt_cname, edt_sid, edt_sname, edt_sdob, edt_sidc;
    Button btn_add_class, btn_add_student, btn_main_class;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_cid = (EditText) findViewById(R.id.edt_class_id);
        edt_cname = (EditText) findViewById(R.id.edt_class_name);
        edt_sid = (EditText) findViewById(R.id.edt_student_id);
        edt_sname = (EditText) findViewById(R.id.edt_student_name);
        edt_sdob = (EditText) findViewById(R.id.edt_student_dob);
        edt_sidc = (EditText) findViewById(R.id.edt_student_id_class);
        btn_add_class = (Button) findViewById(R.id.btn_add_class);
        btn_add_student = (Button) findViewById(R.id.btn_add_student);
        btn_main_class = (Button) findViewById(R.id.btn_main_class);

        btn_add_class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = edt_cid.getText().toString();
                String name = edt_cname.getText().toString();
                Class temp = new Class(id, name, 0);
                ClassDbHelper db = new ClassDbHelper(MainActivity.this);
                db.addNew(temp);

                edt_cid.setText("");
                edt_cname.setText("");
                edt_cid.requestFocus();
            }
        });
        btn_add_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = edt_sid.getText().toString();
                String name = edt_sname.getText().toString();
                String dob = edt_sdob.getText().toString();
                String idclass = edt_sidc.getText().toString();
                Student temp = new Student(id, name, dob, idclass);
                StudentDbHelper db = new StudentDbHelper(MainActivity.this);
                db.addNew(temp);

                edt_sid.setText("");
                edt_sname.setText("");
                edt_sdob.setText("");
                edt_sidc.setText("");
                edt_sid.requestFocus();
            }
        });
        btn_main_class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ClassListActivity.class);
                startActivity(intent);
            }
        });

    }
}