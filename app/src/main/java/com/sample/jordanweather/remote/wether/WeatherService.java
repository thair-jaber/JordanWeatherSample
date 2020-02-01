package com.sample.jordanweather.remote.wether;

import com.sample.jordanweather.models.Resource;
import com.sample.jordanweather.models.WeatherResponse;

import io.reactivex.Flowable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Thair
 * on 1/21/2020.
 */
public interface WeatherService {

    @GET("weather.ashx")
    Flowable<WeatherResponse> getWeatherByCity(@Query("q") String city);

}
