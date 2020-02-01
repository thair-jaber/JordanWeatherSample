package com.sample.jordanweather.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Thair
 * on 1/22/2020.
 */
public class WeatherIcon {

    @SerializedName("value")
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
