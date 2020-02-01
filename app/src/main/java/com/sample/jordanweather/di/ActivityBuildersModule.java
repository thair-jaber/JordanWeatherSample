package com.sample.jordanweather.di;

import com.sample.jordanweather.di.cities.CitiesFragmentBuilderModule;
import com.sample.jordanweather.di.cities.CitiesModule;
import com.sample.jordanweather.di.cities.CitiesViewModelsModule;
import com.sample.jordanweather.di.weather.WeatherInfoFragmentBuilderModule;
import com.sample.jordanweather.di.weather.WeatherModule;
import com.sample.jordanweather.di.weather.WeatherViewModelModule;
import com.sample.jordanweather.ui.weather.WeatherInfoActivity;
import com.sample.jordanweather.ui.cities.CitiesActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Thair
 * on 1/21/2020.
 */
@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
            modules = {CitiesFragmentBuilderModule.class ,
                    CitiesViewModelsModule.class,
                    CitiesModule.class}
            )
    abstract CitiesActivity contributeCitiesActivity();

    @ContributesAndroidInjector(
            modules = {WeatherInfoFragmentBuilderModule.class,
                    WeatherViewModelModule.class
            , WeatherModule.class})
    abstract WeatherInfoActivity contributeWeatherInfoActivity();


}
