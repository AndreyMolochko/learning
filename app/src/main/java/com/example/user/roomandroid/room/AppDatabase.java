package com.example.user.roomandroid.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by User on 10.08.2018.
 */

@Database(entities = {Person.class},version = 4)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PersonDao getPersonDao();
}
