package com.example.a21521003_todolist;

public class Todo {
    private String title;
    private String des;
    private String date;

    public Todo(String title, String des, String date) {
        this.title = title;
        this.des = des;
        this.date = date;
    }


    public String getTitle() {
        return title;
    }

    public String getDes() {
        return des;
    }

    public String getDate() {
        return date;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
