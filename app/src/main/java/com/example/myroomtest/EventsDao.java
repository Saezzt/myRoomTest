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
public interface EventsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertEvent(Events... event);

    @Insert
    public void insertAllEvent(Events[] events);

    @Update
    public void updateEvent(Events... event);

    @Delete
    public void deleteEvent(Events... event);

    @Query("SELECT * FROM events")
    public LiveData<List<Events>> loadAllEvents();

    @Query("SELECT * FROM events WHERE _calendar = :search")
    public LiveData<List<Events>> loadAllEventsWithCal(int search);

}
