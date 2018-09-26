package com.example.android.sunshine.data.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.Date;

@Dao
public interface WeatherDao {

    @Query("SELECT * from weather WHERE date = :date")
    WeatherEntry getWeathersByDate(Date date);

    // Insert all weather entries by bulk when it downloads from the server, handles conflict by replacing it with newer version
    // Use @Insert if nothing else to handle
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void bulkInsert(WeatherEntry... weathers);

}
