package com.example.myroomtest;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marco on 20/06/2018.
 */
@Dao
public interface UsersDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public long insertUser(Users... users);

    @Update
    public int updateUser(Users... users);

    @Delete
    public int deleteUser(Users... users);

    @Query("SELECT * FROM users ORDER BY name ASC")
    public LiveData<ArrayList<Users>> loadAllUsers();
}
