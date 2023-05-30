package com.example.a21521003_phonenumdictionary;

public class PhoneNumber {
    String name;
    String phoneNum;

    public PhoneNumber() {
    }

    public PhoneNumber(String name, String phoneNum) {
        this.name = name;
        this.phoneNum = phoneNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
