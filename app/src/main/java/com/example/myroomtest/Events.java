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
@Entity(tableName = "events", indices = {@Index("calendar"), @Index(value = {"calendar"})}, foreignKeys = @ForeignKey(entity = Calendars.class, parentColumns = "id", childColumns = "calendar", onDelete = CASCADE, onUpdate = CASCADE))
public class Events {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private int eve_id;

    @NonNull
    @ColumnInfo(name = "calendar")
    private int col_id;

    @ColumnInfo(name = "owner")
    @NonNull
    private String owner;

    @NonNull
    private boolean traffic;

    @NonNull
    private boolean meteo;

    private String location;

    private int distance;

    private int duration;

    private int lon;

    private int lat;

    public Events(@NonNull int eve_id, @NonNull int col_id, @NonNull String owner, @NonNull boolean traffic, @NonNull boolean meteo, String location, int distance, int duration, int lon, int lat) {
        this.eve_id = eve_id;
        this.col_id = col_id;
        this.owner = owner;
        this.traffic = traffic;
        this.meteo = meteo;
        this.location = location;
        this.distance = distance;
        this.duration = duration;
        this.lon = lon;
        this.lat = lat;
    }

    @NonNull
    public int getEve_id() {
        return eve_id;
    }

    public void setEve_id(@NonNull int eve_id) {
        this.eve_id = eve_id;
    }

    @NonNull
    public int getCol_id() {
        return col_id;
    }

    public void setCol_id(@NonNull int col_id) {
        this.col_id = col_id;
    }

    @NonNull
    public String getOwner() {
        return owner;
    }

    public void setOwner(@NonNull String owner) {
        this.owner = owner;
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

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
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
