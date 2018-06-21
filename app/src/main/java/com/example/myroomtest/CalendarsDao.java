package com.example.myroomtest;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by Marco on 20/06/2018.
 */
@Dao
public interface CalendarsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public long insertCalendar(Calendars... calendar);

    @Update
    public int updateCalendar(Calendars... calendar);

    @Delete
    public int deleteCalendar(Calendars... calendar);

    @Query("SELECT * FROM calendars")
    public LiveData<List<Calendars>> loadAllCalendars();

    @Query("SELECT * FROM calendar WHERE account_name = :search")
    public LiveData<List<Calendars>> loadAllCalendarsWithAcN(String search);
}
