package com.sample.jordanweather.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.sample.jordanweather.utils.Constants;
import com.sample.jordanweather.db.entity.CityEntity;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;

/**
 * Created by Thair
 * on 1/25/2020.
 */
@Dao
public interface CitiesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertAll(List<CityEntity> cities);

    @Query("SELECT * FROM " + Constants.CITY_TABLE_NAME)
    Flowable<List<CityEntity>> getCities();
}
