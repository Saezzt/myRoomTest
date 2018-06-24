package com.example.myroomtest;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

/**
 * Created by Marco on 20/06/2018.
 */

@Database(entities = {Users.class, Calendars.class, Events.class}, version = 1, exportSchema = false)
public abstract class AgendaRoomDatabase extends RoomDatabase {

    public abstract UsersDao usersDao();
    public abstract EventsDao eventsDao();
    public abstract CalendarsDao calendarsDao();

    private static AgendaRoomDatabase INSTANCE;


    public static AgendaRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AgendaRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AgendaRoomDatabase.class, "agenda_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();

                }
            }
        }
        return INSTANCE;
    }

    //callback attualmente vuota
    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final UsersDao mDao;

        PopulateDbAsync(AgendaRoomDatabase db) {
            mDao = db.usersDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            return null;
        }
    }
}
