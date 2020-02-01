package com.sample.jordanweather.di.cities;

import com.sample.jordanweather.ui.cities.CitiesListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Thair
 * on 1/27/2020.
 */
@Module
public abstract class CitiesFragmentBuilderModule {

    @ContributesAndroidInjector
    abstract CitiesListFragment contributeCitiesListFragment();
}
