package com.example.a21521003_sqlitehomework.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.a21521003_sqlitehomework.entity.Class;

import java.util.ArrayList;

public class ClassDbHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "ClassList.db";
    public static final int DB_VERSION = 1;

    public static final String TBL_NAME = "Class";
    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";
    public static final String COL_STUDENTS = "students";

    public ClassDbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TBL_NAME + "("
                + COL_ID + " text primary key, "
                + COL_NAME + " text, "
                + COL_STUDENTS + " int)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE " + TBL_NAME);
        onCreate(db);
    }

    public ArrayList<Class> loadAll() {
        ArrayList<Class> result = new ArrayList<>();
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.query(TBL_NAME, new String[]{COL_ID, COL_NAME, COL_STUDENTS}, null, null, null, null, null);
            while (cursor.moveToNext()) {
                Class temp = new Class();
                temp.setId(cursor.getString(0));
                temp.setName(cursor.getString(1));
                temp.setStudents(cursor.getInt(2));
                result.add(temp);
            }
            cursor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void addNew(Class temp) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_ID, temp.getId());
        values.put(COL_NAME, temp.getName());
        values.put(COL_STUDENTS, temp.getStudents());
        db.insert(TBL_NAME, null, values);
    }

    public void update(Class temp) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NAME, temp.getName());
        values.put(COL_STUDENTS, temp.getStudents());
        db.update(TBL_NAME, values, COL_ID + "=?", new String[]{"" + temp.getId()});
    }

    public void delete(String id) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TBL_NAME + " WHERE ID='" + id + "'");
    }

    public ArrayList<Class> find(String id) {
        ArrayList<Class> result = new ArrayList<>();
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.query(TBL_NAME, new String[]{COL_ID, COL_NAME, COL_STUDENTS}, null, null, null, null, null);
            while (cursor.moveToNext()) {
                if (cursor.getString(0).equals(id)) {
                    Class temp = new Class();
                    temp.setId(cursor.getString(0));
                    temp.setName(cursor.getString(1));
                    temp.setStudents(cursor.getInt(2));
                    result.add(temp);
                    break;
                }
            }
            cursor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
