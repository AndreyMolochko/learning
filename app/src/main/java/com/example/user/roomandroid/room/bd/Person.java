package com.example.user.roomandroid.room.bd;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;

import com.example.user.roomandroid.room.converters.SkillsConverter;

/**
 * Created by User on 23.08.2018.
 */

@Entity
@TypeConverters({SkillsConverter.class})
public class Person {

    @PrimaryKey(autoGenerate = true)
    public int id;
    @Embedded
    private Work work;
    @Embedded
    private Bio bio;
    @Embedded
    private Location location;

    public Person(Work work, Bio bio, Location location) {
        this.work = work;
        this.bio = bio;
        this.location = location;
    }

    @Ignore
    public Person() {

    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public Bio getBio() {
        return bio;
    }

    public void setBio(Bio bio) {
        this.bio = bio;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
