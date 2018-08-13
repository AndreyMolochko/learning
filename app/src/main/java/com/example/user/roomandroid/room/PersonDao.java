package com.example.user.roomandroid.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by User on 10.08.2018.
 */

@Dao
public interface PersonDao {
    @Insert
    void insertAll(Person... persons);

    @Delete
    void delete(Person person);

    @Query("SELECT * FROM person")
    List<Person> getAllPeople();

    @Query("SELECT name FROM person")
    List<String> getAllNames();
    
}
