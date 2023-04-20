package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.time.chrono.JapaneseDate;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lv_Student ;
    ArrayList<Student> arrStudent;
    StudentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    lv_Student=(ListView) findViewById(R.id.lv_student);
    arrStudent = new ArrayList<Student>();
    arrStudent.add(new Student("21520478","Luong Le Duy Tien",R.drawable.meow1));
    arrStudent.add(new Student("21521003","Pham Nguyen Minh Khoa",R.drawable.meow2));
    arrStudent.add(new Student("21521003","Pham Nhat Quang",R.drawable.meow3));
    arrStudent.add(new Student("19521718","Nguyen Trung Kien",R.drawable.meow4));
    arrStudent.add(new Student("21520739","Le Quoc Dung",R.drawable.meow5));
    adapter = new StudentAdapter(this,R.layout.item_student,arrStudent);
    lv_Student.setAdapter(adapter);
    }
}