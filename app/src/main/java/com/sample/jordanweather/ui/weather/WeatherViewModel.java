package com.sample.jordanweather.ui.weather;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.sample.jordanweather.db.entity.CityEntity;
import com.sample.jordanweather.db.entity.WeatherEntity;
import com.sample.jordanweather.models.Resource;
import com.sample.jordanweather.repository.WeatherRepository;

import javax.inject.Inject;

/**
 * Created by Thair
 * on 1/21/2020.
 */
public class WeatherViewModel extends ViewModel {

    private WeatherRepository weatherRepository;
    public LiveData<Resource<WeatherEntity>> weatherInfo;
    private MutableLiveData<CityEntity> city = new MediatorLiveData<>();



    @Inject
    public WeatherViewModel(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;

        weatherInfo = Transformations.switchMap(city, input -> weatherRepository.getWeather(city.getValue()));

    }

    public void setCity(CityEntity city){
        this.city.setValue(city);
    }
}

