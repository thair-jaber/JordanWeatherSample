package com.sample.jordanweather.ui.cities;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sample.jordanweather.db.entity.CityEntity;
import com.sample.jordanweather.db.dao.CitiesDao;
import com.sample.jordanweather.models.Resource;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Thair
 * on 1/27/2020.
 */
public class CitiesViewModel extends ViewModel {

    private CitiesDao citiesDao;
    public MediatorLiveData<Resource<List<CityEntity>>> cities;
    private MutableLiveData<CityEntity> currentCity = new MutableLiveData<>();


    @Inject
    public CitiesViewModel(CitiesDao citiesDao) {
        this.citiesDao = citiesDao;
        cities = new MediatorLiveData<>();
    }

    public void getCities() {
        cities.setValue(Resource.loading(null));

        LiveData<Resource<List<CityEntity>>> source = LiveDataReactiveStreams.fromPublisher(
                citiesDao.getCities()
                        .onErrorReturn(throwable -> new ArrayList<>())
                        .map((Function<List<CityEntity>, Resource<List<CityEntity>>>) cityEntities -> {
                            if (cityEntities.size() == 0) {
                                return Resource.error("No cities foune", null);
                            }
                            return Resource.success(cityEntities);
                        }).subscribeOn(Schedulers.io())
        );

        cities.addSource(source, listResource -> {
            cities.setValue(listResource);
            cities.removeSource(source);
        });
    }

    public void updateCurrentCity(CityEntity cityEntity) {
        currentCity.setValue(cityEntity);
    }

    public LiveData<CityEntity> observeCurrentCity() {
        return currentCity;
    }
}
