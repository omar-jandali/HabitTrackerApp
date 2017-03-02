package com.example.janda_000.habittrackerapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.janda_000.habittrackerapp.data.HabitContract;
import com.example.janda_000.habittrackerapp.data.HabitDbHelper;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createHabit("Habit 1", 0, 0);
        createHabit("Habit 2", 1, 1);
        createHabit("Habit 3", 2, 2);
        createHabit("Habit 4", 3, 3);
        createHabit("Habit 5", 1, 4);

        Cursor cursor = readInfo();

        try{
            int idIndex = cursor.getColumnIndex(HabitContract.HabitsEntry._ID);
            int nameIndex = cursor.getColumnIndex(HabitContract.HabitsEntry.NAME_COLUMN);
            int frequencyIndex = cursor.getColumnIndex(HabitContract.HabitsEntry.FREQUENCY_COLUMN);
            int typeIndex = cursor.getColumnIndex(HabitContract.HabitsEntry.TYPE_COLUMN);

            while (cursor.moveToNext()){
                int currentId = cursor.getInt(idIndex);
                String currentName = cursor.getString(nameIndex);
                int currentFrequency = cursor.getInt(frequencyIndex);
                int currentType = cursor.getInt(typeIndex);

                Log.v(LOG_TAG, "id:" + currentId + " name: " + currentName + " frequency: " +
                        currentFrequency + " type: " + currentType);

            }
        }finally {

            cursor.close();

        }
    }

    public void createHabit(String name, int frequency, int type){

        HabitDbHelper hDbHelper = new HabitDbHelper(this);
        SQLiteDatabase dB  =  hDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(HabitContract.HabitsEntry.NAME_COLUMN, name);
        values.put(HabitContract.HabitsEntry.FREQUENCY_COLUMN, frequency);
        values.put(HabitContract.HabitsEntry.TYPE_COLUMN, type);

        long newRowId = dB.insert(HabitContract.HabitsEntry.TABLE_NAME, null, values);

    }

    public Cursor readInfo(){
        HabitDbHelper hDbHelper = new HabitDbHelper(this);
        SQLiteDatabase dB = hDbHelper.getReadableDatabase();

        String[] projections = {
                HabitContract.HabitsEntry._ID,
                HabitContract.HabitsEntry.NAME_COLUMN,
                HabitContract.HabitsEntry.FREQUENCY_COLUMN,
                HabitContract.HabitsEntry.TYPE_COLUMN};

        return dB.query(
                HabitContract.HabitsEntry.TABLE_NAME,
                projections,
                null,
                null,
                null,
                null,
                null);
    }
}
