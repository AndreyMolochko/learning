package com.example.user.roomandroid.room;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.user.roomandroid.room.bd.Person;
import com.example.user.roomandroid.room.dao.PersonDao;

/**
 * Created by User on 10.08.2018.
 */

@Database(entities = {Person.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PersonDao getPersonDao();
}
