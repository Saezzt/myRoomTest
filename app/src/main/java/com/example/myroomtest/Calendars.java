package com.example.myroomtest;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by Marco on 20/06/2018.
 */
@Entity(tableName = "calendars", indices = {@Index(value = {"account_name"})}, foreignKeys = @ForeignKey(entity = Users.class, parentColumns = "account_name", childColumns = "account_name", onDelete = CASCADE, onUpdate = CASCADE))
public class Calendars {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "_id")
    private Long _id;

    @NonNull
    @ColumnInfo(name = "account_name")
    private String account_name;

    public Calendars(@NonNull Long _id, @NonNull String account_name) {
        this._id = _id;
        this.account_name = account_name;
    }

    @NonNull
    public Long get_id() {
        return _id;
    }

    public void set_id(@NonNull Long cal_id) {
        this._id = cal_id;
    }

    @NonNull
    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(@NonNull String account_name) {
        this.account_name = account_name;
    }
}
