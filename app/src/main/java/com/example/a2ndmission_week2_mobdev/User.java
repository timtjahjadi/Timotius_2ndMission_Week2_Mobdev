package com.example.a2ndmission_week2_mobdev;

public class User {

    private String _Name, _Address;
    private int _age;

    public User(String name, int age, String address) {
        this._Name = name;
        this._age = age;
        this._Address = address;
    }

    public String get_Name() {
        return _Name;
    }

    public void set_Name(String _Name) {
        this._Name = _Name;
    }

    public String get_Address() {
        return _Address;
    }

    public void set_Address(String _Address) {
        this._Address = _Address;
    }

    public int get_age() {
        return _age;
    }

    public void set_age(int _age) {
        this._age = _age;
    }
}
