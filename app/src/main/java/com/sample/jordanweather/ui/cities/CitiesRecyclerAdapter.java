package com.sample.jordanweather.ui.cities;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.sample.jordanweather.databinding.LayoutCityListItemBinding;
import com.sample.jordanweather.db.entity.CityEntity;
import com.sample.jordanweather.viewmodel.ViewModelProviderFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Thair
 * on 1/29/2020.
 */
public class CitiesRecyclerAdapter extends RecyclerView.Adapter {
    private List<CityEntity> cityEntities;
    @Inject
    ViewModelProviderFactory providerFactory;

    private CitiesViewModel citiesViewModel;

    @Inject
    public CitiesRecyclerAdapter(CitiesViewModel citiesViewModel) {
        this.citiesViewModel = citiesViewModel;
        this.cityEntities = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CityVH(LayoutCityListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((CityVH) holder).bind(cityEntities.get(position));
    }

    @Override
    public int getItemCount() {
        return cityEntities.size();
    }

    public void setCities(List<CityEntity> cities) {
        this.cityEntities.clear();
        this.cityEntities.addAll(cities);
        notifyItemRangeInserted(0, cities.size());
    }

    public class CityVH extends RecyclerView.ViewHolder {
        LayoutCityListItemBinding binding;


        public CityVH(@NonNull LayoutCityListItemBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        public void bind(CityEntity cityEntity) {
            binding.setData(cityEntity);
            binding.setVm(citiesViewModel);
        }
    }

}
