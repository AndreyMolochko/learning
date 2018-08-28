package com.example.user.roomandroid.model;

/**
 * Created by User on 27.08.2018.
 */

public class Person {
    private String name;
    private String secondName;
    private String photoUrl;

    public Person(String name, String secondName, String photoUrl) {
        this.name = name;
        this.secondName = secondName;
        this.photoUrl = photoUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
