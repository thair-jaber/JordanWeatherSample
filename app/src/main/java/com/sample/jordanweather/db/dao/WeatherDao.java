package com.sample.jordanweather.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.sample.jordanweather.utils.Constants;
import com.sample.jordanweather.db.entity.WeatherEntity;

import io.reactivex.Completable;
import io.reactivex.Flowable;

/**
 * Created by Thair
 * on 1/24/2020.
 */
@Dao
public interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public Completable insertWeatherData(WeatherEntity weatherEntity);

    @Query("SELECT * FROM " + Constants.WEATHER_TABLE_NAME  + " where cityId = :cityId")
    public Flowable<WeatherEntity> getWeatherInfo(int cityId);

}
