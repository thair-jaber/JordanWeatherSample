package com.sample.jordanweather.ui.cities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.sample.jordanweather.BaseActivity;
import com.sample.jordanweather.R;
import com.sample.jordanweather.databinding.ActivityCitiesBinding;
import com.sample.jordanweather.utils.FragmentUtils;
import com.sample.jordanweather.viewmodel.ViewModelProviderFactory;

import javax.inject.Inject;

/**
 * Created by Thair
 * on 1/27/2020.
 */
public class CitiesActivity extends BaseActivity {

    private ActivityCitiesBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_cities);

        FragmentUtils.replaceFragmentNoAnimation(this,
                CitiesListFragment.newInstance()
                , mBinding.frameContainer.getId(), false);
    }
}
