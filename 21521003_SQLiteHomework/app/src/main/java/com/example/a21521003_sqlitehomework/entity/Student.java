package com.example.a21521003_sqlitehomework.entity;

public class Student {
    String id;
    String name;
    String dob;
    String id_class;

    public Student() {
    }

    public Student(String id, String name, String dob, String id_class) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.id_class = id_class;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getId_class() {
        return id_class;
    }

    public void setId_class(String id_class) {
        this.id_class = id_class;
    }
}
