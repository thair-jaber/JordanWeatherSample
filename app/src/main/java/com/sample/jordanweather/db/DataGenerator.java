package com.sample.jordanweather.db;

import com.sample.jordanweather.db.entity.CityEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thair
 * on 1/25/2020.
 */
public class DataGenerator {
    private final static String[] CITIES = new String[]{"Amman" , "Irbid" , "Aqaba"};

    public static List<CityEntity> getCities(){
        List<CityEntity> cities = new ArrayList<>();
        for (String s : CITIES){
            cities.add(new CityEntity(s));
        }
        return cities;
    }
}
