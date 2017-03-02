package com.example.janda_000.habittrackerapp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.janda_000.habittrackerapp.data.HabitContract.HabitsEntry;
/**
 * Created by janda_000 on 3/1/2017.
 */

public class HabitDbHelper extends SQLiteOpenHelper{

    // The following is just used for the debiugging process for the stack trace
    public static final String LOG_TAG = HabitDbHelper.class.getSimpleName();

    // The following is the constants that will store the name of the database for later user as
    // as well as the current version of the database
    private static final String DB_NAME = "habits.db";
    private static final int DB_VERSION = 1;

    public HabitDbHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase dB) {

        // THe following is what will create the database table as a string that will be executed
        // in order to build the table
        String SQL_CREATE_TABLE_HABITS = "CREATE TABLE " +
                HabitsEntry.TABLE_NAME + " (" +
                HabitsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                HabitsEntry.NAME_COLUMN + "TEXT NOT NULL, " +
                HabitsEntry.FREQUENCY_COLUMN + "INTEGER NOT NULL DEFAULT 0, " +
                HabitsEntry.TYPE_COLUMN + "INTEGER NOT NULL DEFAULT 0);";
        dB.execSQL(SQL_CREATE_TABLE_HABITS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // there is currently no updated version of this database so there is no need to use this
        // method yet
    }
}
