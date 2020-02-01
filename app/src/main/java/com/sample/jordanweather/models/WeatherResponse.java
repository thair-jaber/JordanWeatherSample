package com.sample.jordanweather.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Thair
 * on 1/21/2020.
 */
public class WeatherResponse {


    @SerializedName("data")
    private WeatherData data;

    public WeatherData getData() {
        return data;
    }

    public void setData(WeatherData data) {
        this.data = data;
    }
}
