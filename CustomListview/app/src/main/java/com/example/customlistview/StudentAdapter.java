package com.example.customlistview;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class StudentAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Student> studentList;

    public StudentAdapter(Context context, int layout, List<Student> studentList) {
        this.context = context;
        this.layout = layout;
        this.studentList = studentList;
    }

    @Override
    public int getCount() {
        return studentList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=inflater.inflate(layout,null);
        TextView tv_Name = (TextView) view.findViewById(R.id.name_item);
        TextView tv_ID = (TextView) view.findViewById(R.id.id_item);
        ImageView iv_Img = (ImageView) view.findViewById(R.id.img_item);

        Student student = studentList.get(i);
        tv_Name.setText(student.getName());
        tv_ID.setText(student.getId());
        iv_Img.setImageResource(student.getImage());

        return view;
    }




}
