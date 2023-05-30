package com.example.a21521003_sqlitehomework.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.a21521003_sqlitehomework.R;
import com.example.a21521003_sqlitehomework.entity.Class;

import java.util.List;

public class ClassAdapter extends BaseAdapter {
    private Context context;
    private List<Class> ClassList;

    public ClassAdapter(Context context, List<Class> classList) {
        this.context = context;
        ClassList = classList;
    }

    @Override
    public int getCount() {
        return ClassList.size();
    }

    @Override
    public Object getItem(int i) {
        return ClassList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return ClassList.get(i).hashCode();
    }

    private class ViewHolder {
        TextView tv_cid, tv_cname, tv_cstudents, tv_cnum;
    }

    ViewHolder viewHolder = null;

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vi = view;
        if (vi == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vi = inflater.inflate(R.layout.item_class, null);
            viewHolder.tv_cid = (TextView) vi.findViewById(R.id.txv_class_id);
            viewHolder.tv_cname = (TextView) vi.findViewById(R.id.txv_class_name);
            viewHolder.tv_cstudents = (TextView) vi.findViewById(R.id.txv_class_student);
            viewHolder.tv_cnum = (TextView) vi.findViewById(R.id.txv_class_num);
            vi.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) vi.getTag();
        }
        Class xclass = ClassList.get(i);
        viewHolder.tv_cid.setText("Id:" + xclass.getId());
        viewHolder.tv_cname.setText("Name:" + xclass.getName());
        viewHolder.tv_cstudents.setText("Students:" + xclass.getStudents());
        viewHolder.tv_cnum.setText("#" + (i + 1));
        return vi;
    }
}
