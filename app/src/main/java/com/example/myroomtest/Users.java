package com.example.myroomtest;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;

/**
 * Created by Marco on 20/06/2018.
 */

@Entity(tableName = "users")
public class Users {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "account_name")
    private String account_name;

    @ColumnInfo(name = "account_type")
    private String account_type;

    public Users(@NonNull String account_name, String account_type) {
        this.account_name = account_name;
        this.account_type = account_type;
    }

    @NonNull
    public String getAccount_name() {
        return account_name;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_name(@NonNull String account_name) {
        this.account_name = account_name;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }
}
