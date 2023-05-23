package com.example.a21521003_sqlitehomework.entity;

public class Class {
    String id;
    String name;
    int students;

    public Class() {
    }

    public Class(String id, String name, int students) {
        this.id = id;
        this.name = name;
        this.students = students;
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

    public int getStudents() {
        return students;
    }

    public void setStudents(int students) {
        this.students = students;
    }
}
