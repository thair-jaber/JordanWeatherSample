package com.sample.jordanweather.ui.cities;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.sample.jordanweather.BaseFragment;
import com.sample.jordanweather.databinding.FragmentCitiesListBinding;
import com.sample.jordanweather.models.Resource;
import com.sample.jordanweather.ui.weather.WeatherInfoActivity;
import com.sample.jordanweather.utils.Constants;
import com.sample.jordanweather.viewmodel.ViewModelProviderFactory;

import javax.inject.Inject;

/**
 * Created by Thair
 * on 1/27/2020.
 */
public class CitiesListFragment extends BaseFragment{


    public static CitiesListFragment newInstance() {
        return new CitiesListFragment();
    }

    @Inject
    ViewModelProviderFactory providerFactory;
    @Inject
    CitiesRecyclerAdapter citiesRecyclerAdapter;

    private CitiesViewModel citiesViewModel;


    @Inject
    public CitiesListFragment() {
    }

    private FragmentCitiesListBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = FragmentCitiesListBinding.inflate(inflater, container, false);
        mBinding.setLifecycleOwner(getViewLifecycleOwner());

        citiesViewModel = new ViewModelProvider(getActivity(), providerFactory).get(CitiesViewModel.class);
        mBinding.setVm(citiesViewModel);
        mBinding.recyclerCities.setAdapter(citiesRecyclerAdapter);

        observeCities();
        observeCurrentCity();

        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        citiesViewModel.getCities();
    }

    private void observeCurrentCity() {
        citiesViewModel.observeCurrentCity().observe(getViewLifecycleOwner(), cityEntity -> {
            startActivity(new Intent(getActivity(), WeatherInfoActivity.class).putExtra(Constants.EXTRA_CITY, cityEntity));
        });
    }

    private void observeCities() {
        citiesViewModel.cities.observe(getViewLifecycleOwner(), listResource -> {
            if (listResource.status == Resource.Status.SUCCESS) {
                citiesRecyclerAdapter.setCities(listResource.data);
            }
        });
    }

}
