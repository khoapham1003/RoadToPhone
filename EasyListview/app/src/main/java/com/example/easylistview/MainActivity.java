package com.example.easylistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lv_Name;
    ArrayList<String> arrName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_Name= (ListView) findViewById(R.id.lv_name);
        arrName = new ArrayList<>();
        arrName.add("Luong Le Duy Tien");
        arrName.add("Pham Nguyen Minh Khoa");
        arrName.add("Pham Nhat Quang");
        arrName.add("Nguyen Trung Kien");
        arrName.add("Le Quoc Dung");
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,
                android.R.layout.simple_list_item_1,
                arrName);
        lv_Name.setAdapter(adapter);

    }
}