package com.example.a21521003_todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.List;

public class TodoAdapter extends BaseAdapter {
private Context context;
private int layout;
private List<Todo> TodoList;

    public TodoAdapter(Context context, int layout, List<Todo> todoList) {
        this.context = context;
        this.layout = layout;
        TodoList = todoList;
    }
    public int getCount(){return TodoList.size();}
    public Object getItem(int i) {return null;}
    public long getItemId(int i) {return 0;}

    public View getView(int i, View view, ViewGroup viewGroup)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=inflater.inflate(layout,null);
        TextView tv_title=(TextView) view.findViewById(R.id.txv_title);
        TextView tv_des = (TextView) view.findViewById(R.id.txv_des);
        TextView tv_date = (TextView) view.findViewById(R.id.txv_date);

        Todo todo=TodoList.get(i);
        tv_title.setText(todo.getTitle());
        tv_des.setText(todo.getDes());
        tv_date.setText(todo.getDate());
        return view;
    }



}
