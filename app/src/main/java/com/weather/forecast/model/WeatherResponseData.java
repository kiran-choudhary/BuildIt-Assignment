package com.weather.forecast.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kiran Kumar Choudhary on 05,May,2019).
 */
public class WeatherResponseData {

    @SerializedName("cnt")
    @Expose
    public int cnt;

    @SerializedName("list")
    @Expose
    private ArrayList<WeatherMainData> weatherMainDataList = new ArrayList<>();

    public ArrayList<WeatherMainData> getWeatherMainDataList() {
        return weatherMainDataList;
    }
}
