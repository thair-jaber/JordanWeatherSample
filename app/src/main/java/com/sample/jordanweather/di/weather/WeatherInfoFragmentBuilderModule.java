package com.sample.jordanweather.di.weather;

import com.sample.jordanweather.ui.weather.WeatherInfoFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Thair
 * on 1/27/2020.
 */
@Module
public abstract class WeatherInfoFragmentBuilderModule {

    @ContributesAndroidInjector
    abstract WeatherInfoFragment contributeWeatherInfoFragment();
}
