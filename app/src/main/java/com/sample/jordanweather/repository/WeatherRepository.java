package com.sample.jordanweather.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;

import com.sample.jordanweather.db.entity.CityEntity;
import com.sample.jordanweather.db.entity.WeatherEntity;
import com.sample.jordanweather.db.dao.WeatherDao;
import com.sample.jordanweather.models.Resource;
import com.sample.jordanweather.models.WeatherResponse;
import com.sample.jordanweather.remote.wether.WeatherService;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

@Singleton
public class WeatherRepository {

    private final WeatherService weatherService;
    private WeatherDao weatherDao;
    private MediatorLiveData<Resource<WeatherEntity>> weather;


    @Inject
    public WeatherRepository(WeatherService weatherService, WeatherDao weatherDao) {
        this.weatherService = weatherService;
        this.weatherDao = weatherDao;

    }

    public MutableLiveData<Resource<WeatherEntity>> getWeather(CityEntity city) {
        weather = new MediatorLiveData<>();
        weather.setValue(Resource.loading(null));

        final LiveData<Resource<WeatherEntity>> source = LiveDataReactiveStreams.fromPublisher(
                weatherDao.getWeatherInfo(city.getId()).subscribeOn(Schedulers.io())
                        .map(weatherEntity -> Resource.success(weatherEntity)));


        final LiveData<Resource<WeatherEntity>> source1 = LiveDataReactiveStreams.fromPublisher(
                weatherService.getWeatherByCity(city.getName())
                        .onErrorReturn(throwable -> new WeatherResponse())
                        .map((Function<WeatherResponse, Resource<WeatherEntity>>) weatherResponse -> {
                            if (weatherResponse == null ||
                                    weatherResponse.getData() == null ||
                                    weatherResponse.getData().getCurrentCondition().size() == 0) {
                                return Resource.error("No data available", null);
                            }
                            WeatherEntity weatherEntity = new WeatherEntity(city.getId(), weatherResponse.getData().getCurrentCondition().get(0).getObservationTime()
                                    , weatherResponse.getData().getCurrentCondition().get(0).getTempC(),
                                    weatherResponse.getData().getCurrentCondition().get(0).getWeatherCode()
                                    , weatherResponse.getData().getCurrentCondition().get(0).getWeatherIconUrl().get(0).getValue()
                                    , weatherResponse.getData().getCurrentCondition().get(0).getWeatherDesc().get(0).getValue()
                                    , weatherResponse.getData().getCurrentCondition().get(0).getWindspeedKmph()
                                    , weatherResponse.getData().getCurrentCondition().get(0).getWinddir16Point()
                                    , weatherResponse.getData().getCurrentCondition().get(0).getHumidity()
                                    , weatherResponse.getData().getCurrentCondition().get(0).getVisibility()
                                    , weatherResponse.getData().getCurrentCondition().get(0).getPressure()
                                    , weatherResponse.getData().getCurrentCondition().get(0).getFeelsLikeC());
                            return Resource.success(weatherEntity);
                        }).subscribeOn(Schedulers.io()));

        weather.addSource(source, weatherDataResource -> weather.setValue(weatherDataResource));

        weather.addSource(source1, weatherDataResource -> {
            if (weatherDataResource.status == Resource.Status.SUCCESS) {
                weatherDao.insertWeatherData(weatherDataResource.data).subscribeOn(Schedulers.io()).subscribe();
                weather.removeSource(source1);
            }
        });


        return weather;
    }


}
