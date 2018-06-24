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
@Entity(tableName = "events", indices = {@Index(value = {"_calendar"})}, foreignKeys = @ForeignKey(entity = Calendars.class, parentColumns = "_id", childColumns = "_calendar", onDelete = CASCADE, onUpdate = CASCADE))
public class Events {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "_id")
    private int _id;

    @NonNull
    @ColumnInfo(name = "_calendar")
    private int _calendar;

    @NonNull
    private boolean traffic;

    @NonNull
    private boolean meteo;

    private  String location;

    private int duration;

    private int lon;

    private int lat;

    public Events(@NonNull int _id, @NonNull int _calendar, @NonNull boolean traffic, @NonNull boolean meteo, String location, int duration, int lon, int lat) {
        this._id = _id;
        this._calendar = _calendar;
        this.traffic = traffic;
        this.meteo = meteo;
        this.location = location;
        this.duration = duration;
        this.lon = lon;
        this.lat = lat;
    }

    @NonNull
    public int get_id() {
        return _id;
    }

    public void set_id(@NonNull int _id) {
        this._id = _id;
    }

    @NonNull
    public int get_calendar() {
        return _calendar;
    }

    public void set_calendar(@NonNull int _calendar) {
        this._calendar = _calendar;
    }

    @NonNull
    public boolean isTraffic() {
        return traffic;
    }

    public void setTraffic(@NonNull boolean traffic) {
        this.traffic = traffic;
    }

    @NonNull
    public boolean isMeteo() {
        return meteo;
    }

    public void setMeteo(@NonNull boolean meteo) {
        this.meteo = meteo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getLon() {
        return lon;
    }

    public void setLon(int lon) {
        this.lon = lon;
    }

    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }
}
