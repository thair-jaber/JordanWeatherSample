package com.sample.jordanweather.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.sample.jordanweather.db.dao.CitiesDao;
import com.sample.jordanweather.db.dao.WeatherDao;
import com.sample.jordanweather.db.entity.CityEntity;
import com.sample.jordanweather.db.entity.WeatherEntity;

/**
 * Created by Thair
 * on 1/24/2020.
 */
@Database(entities = {WeatherEntity.class, CityEntity.class}, version = 1,exportSchema = false)
public abstract class AppDB extends RoomDatabase {

    public static final String DATABASE_NAME = "WeatherDatabase";

    public abstract WeatherDao weatherDao();

    public abstract CitiesDao citiesDao();
}
