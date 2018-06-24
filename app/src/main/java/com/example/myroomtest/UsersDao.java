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
public interface UsersDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(Users... users);

    @Update
    void updateUser(Users... users);

    @Delete
    void deleteUser(Users... users);

    @Query("SELECT * FROM users ORDER BY account_name ASC")
    LiveData<List<Users>> loadAllUsers();

    @Query("SELECT * FROM users ORDER BY account_name ASC")
    List<Users> sLoadAllUsers();
}
