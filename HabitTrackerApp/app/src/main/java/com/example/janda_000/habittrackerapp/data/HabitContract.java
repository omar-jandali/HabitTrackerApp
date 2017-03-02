package com.example.janda_000.habittrackerapp.data;

import android.provider.BaseColumns;

/**
 * Created by janda_000 on 3/1/2017.
 */

final public class HabitContract {

    // THe following is a empty object that allows other classes and methods to use as a constructor
    private HabitContract(){}

    // The following is the method that can be called in order to access all of the table related
    // constants listed below to construct the database and table
    public static final class HabitsEntry implements BaseColumns{

        // the following is the tables name stored in a constant
        public static final String TABLE_NAME = "habits";

        // the following is the list of all of the columns in the initial table that will be used
        // to store all of the different records
        public static final String _ID = BaseColumns._ID;
        public static final String NAME_COLUMN = "name";
        public static final String FREQUENCY_COLUMN = "frequency";
        public static final String TYPE_COLUMN = "type";

        // the following are a list of options that the user has to choose from when it comes to '
        // selecting the different frequencies for a new habit
        public static final int FREQUENCY_OTHER = 0;
        public static final int FREQUENCY_DAILY = 1;
        public static final int FREQUENCY_WEEKLY = 2;
        public static final int FREQUENCY_MONTHLY = 3;

        // the following is a list of all the different options that the use will have to select
        // from when it comes to seleting the type of habit that is occuring
        public static final int TYPE_OTHER = 0;
        public static final int TYPE_PERSONAL = 1;
        public static final int TYPE_INVESTMENT = 2;
        public static final int TYPE_BUSINESS = 3;
        public static final int TYPE_FAMILY = 4;

    }

}
