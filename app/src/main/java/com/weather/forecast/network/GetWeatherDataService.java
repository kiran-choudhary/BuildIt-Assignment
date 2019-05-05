package com.weather.forecast.network;

import com.weather.forecast.model.WeatherMainData;
import com.weather.forecast.model.WeatherResponseData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by Kiran Kumar Choudhary on 05,May,2019).
 */
public interface GetWeatherDataService {

    @GET
    Call<WeatherResponseData> getWeatherData(@Url String url);
}
