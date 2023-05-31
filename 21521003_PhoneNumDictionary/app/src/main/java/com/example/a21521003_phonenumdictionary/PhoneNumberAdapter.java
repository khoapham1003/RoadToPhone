package com.example.a21521003_phonenumdictionary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PhoneNumberAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<PhoneNumber> phoneNumberList;

    public PhoneNumberAdapter(Context context, int layout, List<PhoneNumber> phoneNumberList) {
        this.context = context;
        this.layout = layout;
        this.phoneNumberList = phoneNumberList;
    }

    @Override
    public int getCount() {
        return phoneNumberList.size();
    }

    @Override
    public Object getItem(int i) {
        return phoneNumberList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);
        TextView tv_ID = (TextView) view.findViewById(R.id.txv_id);
        TextView tv_Name = (TextView) view.findViewById(R.id.txv_name);
        TextView tv_PhoneNum = (TextView) view.findViewById(R.id.txv_phonenum);

        PhoneNumber student = phoneNumberList.get(i);
        tv_ID.setText("#" + (i + 1));
        tv_Name.setText(student.getName());
        tv_PhoneNum.setText(student.getPhoneNum());

        return view;
    }
}
