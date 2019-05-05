package com.weather.forecast.manager;

import com.weather.forecast.model.WeatherMainData;

import java.util.ArrayList;

/**
 * Created by Kiran Kumar Choudhary on 05,May,2019).
 */
public interface DataCallback {

    public void onResponse(ArrayList<WeatherMainData> weatherMainDataArrayList);

    public void onFailure(String message);
}
