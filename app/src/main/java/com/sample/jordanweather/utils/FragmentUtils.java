package com.sample.jordanweather.utils;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.sample.jordanweather.BaseFragment;
import com.sample.jordanweather.R;

public class FragmentUtils {


    public static BaseFragment replaceFragmentNoAnimation(FragmentActivity activity,
                                                          BaseFragment fragment,
                                                          int container,
                                                          boolean addToStack) {
        return replaceFragment(activity, fragment, container, false, addToStack);
    }

    public static BaseFragment replaceFragmentAnimation(FragmentActivity activity,
                                                        BaseFragment fragment,
                                                        int container,
                                                        boolean addToStack) {
        return replaceFragment(activity, fragment, container, true, addToStack);
    }

    public static BaseFragment replaceFragment(FragmentActivity activity,
                                               BaseFragment baseFragment,
                                               int container,
                                               boolean enableAnimation,
                                               boolean addToStack) {

        FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
        BaseFragment existingFragment = (BaseFragment) activity.getSupportFragmentManager().
                findFragmentByTag(baseFragment.getClass().toString());
        if (existingFragment != null){
            baseFragment = existingFragment;
        }
        if (enableAnimation) {
            ft.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left,
                    R.anim.slide_in_left, R.anim.slide_out_right);
        }
        ft.replace(container, baseFragment, baseFragment.getClass().toString());
        if (addToStack) {
            ft.addToBackStack(baseFragment.getClass().toString());
        }
        ft.commit();
        return baseFragment;
    }


    public static BaseFragment replaceFragmentWithCrossFade(FragmentActivity activity,
                                                            BaseFragment baseFragment,
                                                            int container,
                                                            boolean enableAnimation,
                                                            boolean addToStack) {

        FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
        BaseFragment existingFragment = (BaseFragment) activity.getSupportFragmentManager().
                findFragmentByTag(baseFragment.getClass().toString());
        if (existingFragment != null){
            baseFragment = existingFragment;
        }
        if (enableAnimation) {
            ft.setCustomAnimations(R.anim.fade_in, R.anim.fade_out,
                    R.anim.fade_in, R.anim.fade_out);
        }
        ft.replace(container, baseFragment, baseFragment.getClass().toString());
        if (addToStack) {
            ft.addToBackStack(baseFragment.getClass().toString());
        }
        ft.commit();
        return baseFragment;
    }

}
