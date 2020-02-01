package com.sample.jordanweather.di.weather;

import com.sample.jordanweather.db.AppDB;
import com.sample.jordanweather.db.entity.CityEntity;
import com.sample.jordanweather.db.dao.WeatherDao;
import com.sample.jordanweather.remote.wether.WeatherService;
import com.sample.jordanweather.repository.WeatherRepository;
import com.sample.jordanweather.ui.weather.WeatherInfoActivity;
import com.sample.jordanweather.utils.Constants;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Thair
 * on 1/21/2020.
 */
@Module
public class WeatherModule {

    @Provides
    static CityEntity provideCityEntity(WeatherInfoActivity weatherInfoActivity){
        return weatherInfoActivity.getIntent().getParcelableExtra(Constants.EXTRA_CITY);
    }
    @Provides
    static WeatherRepository provideWeatherRepository(WeatherService weatherService,WeatherDao weatherDao){
        return new WeatherRepository(weatherService,weatherDao);
    }

    @Provides
    static WeatherDao provideWeatherDao(AppDB appDB){
        return appDB.weatherDao();
    }

    @Provides
    static WeatherService provideWeatherService(Retrofit retrofit){
        return retrofit.create(WeatherService.class);
    }
}
