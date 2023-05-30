package com.example.a21521003_sqlitehomework.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.a21521003_sqlitehomework.entity.Class;
import com.example.a21521003_sqlitehomework.entity.Student;

import java.util.ArrayList;

public class StudentDbHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "StudentList.db";
    public static final int DB_VERSION = 1;

    public static final String TBL_NAME = "Student";
    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";
    public static final String COL_DOB = "dob";
    public static final String COL_ID_CLASS = "id_class";


    public StudentDbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TBL_NAME + "("
                + COL_ID + " text primary key, "
                + COL_NAME + " text, "
                + COL_DOB + " text, "
                + COL_ID_CLASS + " text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE " + TBL_NAME);
        onCreate(db);
    }

    public ArrayList<Student> loadAll() {
        ArrayList<Student> result = new ArrayList<>();
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.query(TBL_NAME, new String[]{COL_ID, COL_NAME, COL_DOB, COL_ID_CLASS}, null, null, null, null, null);
            while (cursor.moveToNext()) {
                Student temp = new Student();
                temp.setId(cursor.getString(0));
                temp.setName(cursor.getString(1));
                temp.setDob(cursor.getString(2));
                temp.setId_class(cursor.getString(3));
                result.add(temp);
            }
            cursor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void addNew(Student temp) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_ID, temp.getId());
        values.put(COL_NAME, temp.getName());
        values.put(COL_DOB, temp.getDob());
        values.put(COL_ID_CLASS, temp.getId_class());
        db.insert(TBL_NAME, null, values);
    }

    public void update(Student temp) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NAME, temp.getName());
        values.put(COL_DOB, temp.getDob());
        values.put(COL_ID_CLASS, temp.getId_class());
        db.update(TBL_NAME, values, COL_ID + "=?", new String[]{"" + temp.getId()});
    }

    public ArrayList<Student> loadAllInClass(String idclass) {
        ArrayList<Student> result = new ArrayList<>();
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.query(TBL_NAME, new String[]{COL_ID, COL_NAME, COL_DOB, COL_ID_CLASS}, null, null, null, null, null);
            while (cursor.moveToNext()) {
                if (cursor.getString(3).equals(idclass)) {
                    Student temp = new Student();
                    temp.setId(cursor.getString(0));
                    temp.setName(cursor.getString(1));
                    temp.setDob(cursor.getString(2));
                    temp.setId_class(cursor.getString(3));
                    result.add(temp);
                }
            }
            cursor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void delete(String id) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TBL_NAME + " WHERE ID='" + id + "'");
    }
}
