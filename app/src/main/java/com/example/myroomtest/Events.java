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
    private Long _id;

    @NonNull
    @ColumnInfo(name = "_calendar")
    private Long _calendar;

    @NonNull
    private boolean traffic;

    @NonNull
    private boolean meteo;

    private  String location;

    private Integer duration;

    private Double lon;

    private Double lat;

    public Events(@NonNull Long _id, @NonNull Long _calendar, @NonNull boolean traffic, @NonNull boolean meteo, String location, Integer duration, Double lon, Double lat) {
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
    public Long get_id() {
        return _id;
    }

    public void set_id(@NonNull Long _id) {
        this._id = _id;
    }

    @NonNull
    public Long get_calendar() {
        return _calendar;
    }

    public void set_calendar(@NonNull Long _calendar) {
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

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }
}
