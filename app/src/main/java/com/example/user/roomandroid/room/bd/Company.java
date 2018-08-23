package com.example.user.roomandroid.room.bd;

import android.arch.persistence.room.Ignore;

/**
 * Created by User on 23.08.2018.
 */

public class Company {
    private String position;
    private String experience;
    private String technology;

    public Company(String position, String experience, String technology) {
        this.position = position;
        this.experience = experience;
        this.technology = technology;
    }

    @Ignore
    public Company() {

    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }
}
