package com.example.a21521003_sqlitehomework;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a21521003_sqlitehomework.adapter.ClassAdapter;
import com.example.a21521003_sqlitehomework.adapter.StudentAdapter;
import com.example.a21521003_sqlitehomework.db.ClassDbHelper;
import com.example.a21521003_sqlitehomework.db.StudentDbHelper;

public class StudentListActivity extends AppCompatActivity {
    Button btn_student_main, btn_student_class;
    ListView lv_student;
    TextView tv_id, tv_name, tv_stu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        lv_student = (ListView) findViewById(R.id.lv_Student);
        btn_student_main = (Button) findViewById(R.id.btn_student_main);
        btn_student_class = (Button) findViewById(R.id.btn_student_class);
        tv_id = (TextView) findViewById(R.id.txv_c_id);
        tv_name = (TextView) findViewById(R.id.txv_c_name);
        tv_stu = (TextView) findViewById(R.id.txv_c_students);

        Intent getintent = getIntent();
        tv_id.setText(String.valueOf("Id:" + getintent.getStringExtra("class_id")));
        tv_name.setText(String.valueOf("Name:" + getintent.getStringExtra("class_name")));
        tv_stu.setText(String.valueOf("Students:" + getintent.getIntExtra("class_students", 0)));

        StudentDbHelper db = new StudentDbHelper(this);
//        StudentAdapter adapter = new StudentAdapter(this, db.loadAll());
        StudentAdapter adapter = new StudentAdapter(this, db.loadAllInClass(getintent.getStringExtra("class_id")));
        lv_student.setAdapter(adapter);


        btn_student_class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(StudentListActivity.this, ClassListActivity.class);
                startActivity(intent3);
                finish();
            }
        });
        btn_student_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentListActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        lv_student.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                StudentDbHelper db = new StudentDbHelper(StudentListActivity.this);
                db.delete(db.loadAll().get(i).getId());
                StudentAdapter adapter1 = new StudentAdapter(StudentListActivity.this, db.loadAll());
                lv_student.setAdapter(adapter1);
                Toast.makeText(getApplicationContext(), "Delete Successfully", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}