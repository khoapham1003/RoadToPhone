package com.example.a21521003_sqlitehomework.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.a21521003_sqlitehomework.R;
import com.example.a21521003_sqlitehomework.entity.Student;

import java.util.List;

public class StudentAdapter extends BaseAdapter {
    private Context context;
    private List<Student> StudentList;

    public StudentAdapter(Context context, List<Student> studentList) {
        this.context = context;
        StudentList = studentList;
    }

    @Override
    public int getCount() {
        return StudentList.size();
    }

    @Override
    public Object getItem(int i) {
        return StudentList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return StudentList.get(i).hashCode();
    }

    private class ViewHolder {
        TextView tv_sid, tv_sname, tv_sdob;
    }

    ViewHolder viewHolder = null;

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vi = view;
        if (vi == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vi = inflater.inflate(R.layout.item_student, null);
            viewHolder.tv_sid = (TextView) vi.findViewById(R.id.txv_student_id);
            viewHolder.tv_sname = (TextView) vi.findViewById(R.id.txv_student_name);
            viewHolder.tv_sdob = (TextView) vi.findViewById(R.id.txv_student_dob);
            vi.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) vi.getTag();
        }
        Student student = StudentList.get(i);
        viewHolder.tv_sid.setText("Id:" + student.getId());
        viewHolder.tv_sname.setText("Name:" + student.getName());
        viewHolder.tv_sdob.setText("DoB:" + student.getDob());
        return vi;
    }
}










