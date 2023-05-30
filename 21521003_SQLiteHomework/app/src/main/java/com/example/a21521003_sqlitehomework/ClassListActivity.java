package com.example.a21521003_sqlitehomework;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a21521003_sqlitehomework.adapter.ClassAdapter;
import com.example.a21521003_sqlitehomework.adapter.StudentAdapter;
import com.example.a21521003_sqlitehomework.db.ClassDbHelper;
import com.example.a21521003_sqlitehomework.db.StudentDbHelper;
import com.example.a21521003_sqlitehomework.entity.Class;

public class ClassListActivity extends AppCompatActivity {
    ListView lv_class;
    Button btn_class_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_list);

        lv_class = (ListView) findViewById(R.id.lv_Class);
        btn_class_main = (Button) findViewById(R.id.btn_class_main);
        ClassDbHelper db = new ClassDbHelper(this);
        loadStudents();
        ClassAdapter adapter = new ClassAdapter(this, db.loadAll());
        lv_class.setAdapter(adapter);


        btn_class_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ClassListActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        lv_class.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                ClassDbHelper db = new ClassDbHelper(ClassListActivity.this);
                db.delete(db.loadAll().get(i).getId());
                ClassAdapter adapter1 = new ClassAdapter(ClassListActivity.this, db.loadAll());
                lv_class.setAdapter(adapter1);
                Toast.makeText(getApplicationContext(), "Delete Successfully", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        lv_class.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(ClassListActivity.this, StudentListActivity.class);
                ClassDbHelper db = new ClassDbHelper(ClassListActivity.this);
                intent.putExtra("class_id", db.loadAll().get(i).getId());
                intent.putExtra("class_name", db.loadAll().get(i).getName());
                intent.putExtra("class_students", db.loadAll().get(i).getStudents());
                startActivity(intent);
                finish();
            }
        });
    }

    public void loadStudents() {
        ClassDbHelper db = new ClassDbHelper(this);
        StudentDbHelper studb = new StudentDbHelper(this);
        for (int i = 0; i < db.loadAll().size(); i++) {
            Class xclass = db.loadAll().get(i);
            int students = 0;
            for (int j = 0; j < studb.loadAll().size(); j++) {
                if (xclass.getId().equals(studb.loadAll().get(j).getId_class()))
                    students++;
            }
            xclass.setStudents(students);
            db.update(xclass);
        }

    }
}