package com.example.user.roomandroid.room.bd;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;

import com.example.user.roomandroid.room.converters.SkillsConverter;

import java.util.List;

/**
 * Created by User on 23.08.2018.
 */

public class Work {
    @Embedded
    private Company company;
    @TypeConverters({SkillsConverter.class})
    private List<String>skills;

    public Work(Company company, List<String> skills) {
        this.company = company;
        this.skills = skills;
    }

    public Work() {

    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }
}
