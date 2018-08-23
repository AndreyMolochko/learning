package com.example.user.roomandroid.room.bd;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;

/**
 * Created by User on 23.08.2018.
 */

@Entity
public class Bio {
    public String name;
    private int dateOfBirthday;
    private String sex;
    private String surname;

    public Bio(int dateOfBirthday, String sex, String name, String surname) {
        this.dateOfBirthday = dateOfBirthday;
        this.sex = sex;
        this.name = name;
        this.surname = surname;
    }

    public Bio() {

    }

    public int getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(int dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
