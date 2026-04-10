package com.example.roomlidrarydatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Expense.class,exportSchema = false,version = 1)
public abstract class DatabaseHelper extends RoomDatabase {
    private static final String DB_NAME = "expensedb";
    private static DatabaseHelper instanse;

    public static synchronized DatabaseHelper getdb(Context context){       //synchronized meaning at a time
                                                                        // only 1 operation is called from database
        if(instanse==null){
            instanse= Room.databaseBuilder(context, DatabaseHelper.class,DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
            return instanse;
    }

    public abstract ExpenseDao expenseDao();

}