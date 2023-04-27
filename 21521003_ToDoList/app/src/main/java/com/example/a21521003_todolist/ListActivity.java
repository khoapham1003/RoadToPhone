package com.example.a21521003_todolist;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.icu.number.IntegerWidth;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == MainActivity.RESULT_OK) {
                        Intent intent2 = result.getData();
                        title=intent2.getStringExtra("newTodo_title");
                        des=intent2.getStringExtra("newTodo_des");
                        date=intent2.getStringExtra("newTodo_date");
                        newTodo.setTitle(title);
                        newTodo.setDes(des);
                        newTodo.setDate(date);
                        newTodo=new Todo(title,des,date);
                    }
                }
            });
    String title,des,date;
    Todo newTodo=new Todo(title,des,date);
    private ListView lv_todo;
    ArrayList<Todo> arrTodo;
    TodoAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        lv_todo=(ListView) findViewById(R.id.lv_todo);
        arrTodo=new ArrayList<Todo>();
        adapter=new TodoAdapter(this,R.layout.item_todo,arrTodo);
        lv_todo.setAdapter(adapter);
        setUpListViewListener();
    }

    private void setUpListViewListener() {
        lv_todo.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Context context = getApplicationContext();
                PopupMenu popupMenu = new PopupMenu(context,lv_todo);
                popupMenu.getMenuInflater().inflate(R.menu.popupmenu_todo,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.pumenu_delete: {
                                arrTodo.remove(i);
                                lv_todo.setAdapter(adapter);
                                //adapter.notifyDataSetChanged();
                                break;
                            }
                            case R.id.pumenu_edit:{
                                launcher.launch(new Intent(ListActivity.this,MainActivity.class));
                                arrTodo.set(i,newTodo);
                                break;
                            }
                        }
                        return false;
                    }
                });
                popupMenu.show();
                //adapter.notifyDataSetChanged();
                return true;
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) //them menu
    {
        getMenuInflater().inflate(R.menu.menu_todo,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {
            case R.id.menu_newitem:
                Intent intent3 = new Intent(ListActivity.this,MainActivity.class);
                launcher.launch(intent3);
                arrTodo.add(newTodo);
                break;
            }
                return super.onOptionsItemSelected(item);
    }









}