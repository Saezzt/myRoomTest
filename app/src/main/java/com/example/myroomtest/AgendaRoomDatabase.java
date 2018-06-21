package com.example.myroomtest;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by Marco on 20/06/2018.
 */

@Database(entities = {Users.class, Calendars.class, Events.class}, version = 1)
public abstract class AgendaRoomDatabase extends RoomDatabase {

    public abstract UsersDao usersDao();
    public abstract EventsDao eventsDao();
    public abstract CalendarsDao calendarsDao();

    private static AgendaRoomDatabase INSTANCE;


    static AgendaRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AgendaRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AgendaRoomDatabase.class, "agenda_database")
                            .build();

                }
            }
        }
        return INSTANCE;
    }

}
