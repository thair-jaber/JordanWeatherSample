package com.sample.jordanweather.db.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.sample.jordanweather.utils.Constants;

/**
 * Created by Thair
 * on 1/24/2020.
 */
@Entity(indices = {@Index(value = {"cityId"} , unique = true )},
        tableName = Constants.WEATHER_TABLE_NAME,
        foreignKeys = {
        @ForeignKey(entity = CityEntity.class,
                parentColumns = "id",
                childColumns = "cityId")
})
public class WeatherEntity {
    private int cityId;
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "observation_time")
    private String observationTime;
    @ColumnInfo(name = "temp_C")
    private String tempC;
    @ColumnInfo(name = "weatherCode")
    private String weatherCode;
    @ColumnInfo(name = "weatherIconUrl")
    private String weatherIconUrl;
    @ColumnInfo(name = "weatherDesc")
    private String weatherDesc;
    @ColumnInfo(name = "windspeedKmph")
    private String windspeedKmph;
    @ColumnInfo(name = "winddir16Point")
    private String winddir16Point;
    @ColumnInfo(name = "humidity")
    private String humidity;
    @ColumnInfo(name = "visibility")
    private String visibility;
    @ColumnInfo(name = "pressure")
    private String pressure;
    @ColumnInfo(name = "feelsLikeC")
    private String feelsLikeC;

    public WeatherEntity() {
    }

    public WeatherEntity(int cityId,String observationTime, String tempC, String weatherCode, String weatherIconUrl, String weatherDesc, String windspeedKmph, String winddir16Point, String humidity, String visibility, String pressure, String feelsLikeC) {
        this.cityId = cityId;
        this.observationTime = observationTime;
        this.tempC = tempC;
        this.weatherCode = weatherCode;
        this.weatherIconUrl = weatherIconUrl;
        this.weatherDesc = weatherDesc;
        this.windspeedKmph = windspeedKmph;
        this.winddir16Point = winddir16Point;
        this.humidity = humidity;
        this.visibility = visibility;
        this.pressure = pressure;
        this.feelsLikeC = feelsLikeC;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

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

    public String getWeatherIconUrl() {
        return weatherIconUrl;
    }

    public void setWeatherIconUrl(String weatherIconUrl) {
        this.weatherIconUrl = weatherIconUrl;
    }

    public String getWeatherDesc() {
        return weatherDesc;
    }

    public void setWeatherDesc(String weatherDesc) {
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
        return feelsLikeC;
    }

    public void setFeelsLikeC(String feelsLikeC) {
        this.feelsLikeC = feelsLikeC;
    }
}
