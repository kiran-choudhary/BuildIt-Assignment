package com.weather.forecast.manager;

import com.weather.forecast.model.WeatherMainData;
import com.weather.forecast.model.WeatherResponseData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kiran Kumar Choudhary on 05,May,2019).
 */
public interface WeatherViewInteractor {

    public void onUpdateData(ArrayList<WeatherMainData> weatherMainDataArrayList);

    public void onError(String message);
}
