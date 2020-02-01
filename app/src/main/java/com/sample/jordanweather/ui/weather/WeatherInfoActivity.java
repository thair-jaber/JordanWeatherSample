package com.sample.jordanweather.ui.weather;

import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.sample.jordanweather.BaseActivity;
import com.sample.jordanweather.R;
import com.sample.jordanweather.databinding.ActivityWeatherInfoBinding;
import com.sample.jordanweather.utils.FragmentUtils;


public class WeatherInfoActivity extends BaseActivity {


    private ActivityWeatherInfoBinding mBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_weather_info);

        FragmentUtils.replaceFragmentNoAnimation(this,
                WeatherInfoFragment.newInstance()
                , mBinding.container.getId(), false);

    }

}
