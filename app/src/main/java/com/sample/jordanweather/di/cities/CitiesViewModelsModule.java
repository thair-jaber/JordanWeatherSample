package com.sample.jordanweather.di.cities;

import androidx.lifecycle.ViewModel;

import com.sample.jordanweather.di.ViewModelKey;
import com.sample.jordanweather.ui.cities.CitiesViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by Thair
 * on 1/27/2020.
 */
@Module
public abstract class CitiesViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(CitiesViewModel.class)
    public abstract ViewModel bindCitiesViewModel(CitiesViewModel viewModel);
}
