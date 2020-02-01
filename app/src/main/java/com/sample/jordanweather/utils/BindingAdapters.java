package com.sample.jordanweather.utils;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.sample.jordanweather.R;

import javax.inject.Inject;

/**
 * Created by Thair
 * on 2/1/2020.
 */
public class BindingAdapters {

    @BindingAdapter("loadImage")
    public static void loadImage(ImageView imageView , String url){
        if (url == null || url.isEmpty()){
            return;
        }
        GlideApp.with(imageView.getContext())
                .load(url)
                .error(R.drawable.ic_broken_image_black_24dp)
                .into(imageView);
    }
}
