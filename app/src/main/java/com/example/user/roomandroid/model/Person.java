package com.example.user.roomandroid.model;

/**
 * Created by User on 27.08.2018.
 */

public class Person {
    private String name;
    private String age;
    private String photoUrl;

    public Person(String name, String age, String photoUrl) {
        this.name = name;
        this.age = age;
        this.photoUrl = photoUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
