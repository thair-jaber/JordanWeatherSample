package com.sample.jordanweather.ui.weather;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.sample.jordanweather.BaseFragment;
import com.sample.jordanweather.databinding.FragmentWeatherInfoLayoutBinding;
import com.sample.jordanweather.db.entity.CityEntity;
import com.sample.jordanweather.viewmodel.ViewModelProviderFactory;

import javax.inject.Inject;

/**
 * Created by Thair
 * on 2/1/2020.
 */
public class WeatherInfoFragment extends BaseFragment {

    public static WeatherInfoFragment newInstance() {
        return new WeatherInfoFragment();
    }

    @Inject
    CityEntity currentCity;
    @Inject
    ViewModelProviderFactory providerFactory;
    private WeatherViewModel weatherViewModel;

    private FragmentWeatherInfoLayoutBinding mBinding;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = FragmentWeatherInfoLayoutBinding.inflate(inflater, container, false);
        mBinding.setLifecycleOwner(getViewLifecycleOwner());

        weatherViewModel = new ViewModelProvider(this, providerFactory).get(WeatherViewModel.class);
        mBinding.setVm(weatherViewModel);

        weatherViewModel.setCity(currentCity);


        return mBinding.getRoot();
    }

}
