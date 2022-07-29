package com.example.taskfincorp;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties

public class User {


    String name;
    String age;
    String city;

    public User() {
    }

    public User(String name, String age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }
}
