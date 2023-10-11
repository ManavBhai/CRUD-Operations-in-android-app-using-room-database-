package com.codewithmanav.room.database;


import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {users.class},version = 2)
public abstract class usersDatabase extends RoomDatabase {

    private static final String DB_NAME = "usersDB";
    private static usersDatabase INSTANCE;
    public abstract userDao getDao();

    public static synchronized usersDatabase getDB(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, usersDatabase.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
}
