package com.sample.jordanweather.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Thair
 * on 1/22/2020.
 */
public class WeatherData {
    @SerializedName("current_condition")
    private List<CurrentCondition> currentCondition;

    public List<CurrentCondition> getCurrentCondition() {
        return currentCondition;
    }

    public void setCurrentCondition(List<CurrentCondition> currentCondition) {
        this.currentCondition = currentCondition;
    }
}
