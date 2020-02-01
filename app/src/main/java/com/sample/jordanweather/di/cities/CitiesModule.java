package com.sample.jordanweather.di.cities;

import androidx.lifecycle.ViewModelProvider;

import com.sample.jordanweather.db.AppDB;
import com.sample.jordanweather.db.dao.CitiesDao;
import com.sample.jordanweather.db.dao.WeatherDao;
import com.sample.jordanweather.ui.cities.CitiesActivity;
import com.sample.jordanweather.ui.cities.CitiesListFragment;
import com.sample.jordanweather.ui.cities.CitiesRecyclerAdapter;
import com.sample.jordanweather.ui.cities.CitiesViewModel;
import com.sample.jordanweather.viewmodel.ViewModelProviderFactory;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Thair
 * on 1/26/2020.
 */
@Module
public class CitiesModule {

    @Provides
    static CitiesRecyclerAdapter provideCitiesAdapter(CitiesActivity activity,ViewModelProviderFactory factory){
        CitiesViewModel citiesViewModel = new ViewModelProvider(activity,factory).get(CitiesViewModel.class);
        return new CitiesRecyclerAdapter(citiesViewModel);
    }

    @Provides
    static CitiesDao provideCitiesDao(AppDB appDB){
        return appDB.citiesDao();
    }
}
