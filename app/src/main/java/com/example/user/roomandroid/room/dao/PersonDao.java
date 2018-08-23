package com.example.user.roomandroid.room.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.user.roomandroid.room.bd.Bio;
import com.example.user.roomandroid.room.bd.Person;

import java.util.List;

/**
 * Created by User on 23.08.2018.
 */

@Dao
public interface PersonDao {
    @Insert
    void insertPersons(Person ... person);

    @Delete
    void deletePerson(Person person);

    @Update
    void update(Person person);

    @Query("SELECT * FROM person")
    List<Person>getAllPerson();

    @Query("SELECT * FROM person WHERE id = :myId")
    List<Person>getPersonsById(int myId);

    //@Query("SELECT * FROM person")
    //List<Person>getPersonByDate(int date);


    //TODO : delete,update,query(where ), different;
}
