package com.sample.jordanweather.di.weather;

import androidx.lifecycle.ViewModel;

import com.sample.jordanweather.di.ViewModelKey;
import com.sample.jordanweather.ui.weather.WeatherViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by Thair
 * on 1/21/2020.
 */

@Module
public abstract class WeatherViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(WeatherViewModel.class)
    public abstract ViewModel bindWeatherViewModel(WeatherViewModel viewModel);

}
