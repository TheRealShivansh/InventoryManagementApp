package com.example.inventorymanagementapp.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.inventorymanagementapp.interfaces.MyDao;

@Database(entities = DataModel.class,version = 2,exportSchema = false)
public abstract class RoomDB extends RoomDatabase {

    private static RoomDB instance;

    public abstract MyDao myDao();

    public static synchronized RoomDB getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), RoomDB.class, "item_database")
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build();
        }
        return instance;
    }
}
