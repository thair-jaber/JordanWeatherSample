package com.sample.jordanweather.models;

import com.google.gson.annotations.SerializedName;
import com.sample.jordanweather.models.WeatherDescription;
import com.sample.jordanweather.models.WeatherIcon;

import java.util.List;

/**
 * Created by Thair
 * on 1/22/2020.
 */
public class CurrentCondition {

    @SerializedName("observation_time")
    private String observationTime;
    @SerializedName("temp_C")
    private String tempC;
    @SerializedName("weatherCode")
    private String weatherCode;
    @SerializedName("weatherIconUrl")
    private List<WeatherIcon> weatherIconUrl;
    @SerializedName("weatherDesc")
    private List<WeatherDescription> weatherDesc;
    @SerializedName("windspeedKmph")
    private String windspeedKmph;
    @SerializedName("winddir16Point")
    private String winddir16Point;
    @SerializedName("humidity")
    private String humidity;
    @SerializedName("visibility")
    private String visibility;
    @SerializedName("pressure")
    private String pressure;
    @SerializedName("FeelsLikeC")
    private String FeelsLikeC;

    public String getObservationTime() {
        return observationTime;
    }

    public void setObservationTime(String observationTime) {
        this.observationTime = observationTime;
    }

    public String getTempC() {
        return tempC;
    }

    public void setTempC(String tempC) {
        this.tempC = tempC;
    }

    public String getWeatherCode() {
        return weatherCode;
    }

    public void setWeatherCode(String weatherCode) {
        this.weatherCode = weatherCode;
    }

    public List<WeatherIcon> getWeatherIconUrl() {
        return weatherIconUrl;
    }

    public void setWeatherIconUrl(List<WeatherIcon> weatherIconUrl) {
        this.weatherIconUrl = weatherIconUrl;
    }

    public List<WeatherDescription> getWeatherDesc() {
        return weatherDesc;
    }

    public void setWeatherDesc(List<WeatherDescription> weatherDesc) {
        this.weatherDesc = weatherDesc;
    }

    public String getWindspeedKmph() {
        return windspeedKmph;
    }

    public void setWindspeedKmph(String windspeedKmph) {
        this.windspeedKmph = windspeedKmph;
    }

    public String getWinddir16Point() {
        return winddir16Point;
    }

    public void setWinddir16Point(String winddir16Point) {
        this.winddir16Point = winddir16Point;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getFeelsLikeC() {
        return FeelsLikeC;
    }

    public void setFeelsLikeC(String feelsLikeC) {
        FeelsLikeC = feelsLikeC;
    }
}
