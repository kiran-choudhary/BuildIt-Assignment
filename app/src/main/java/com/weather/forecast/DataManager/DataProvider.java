package com.weather.forecast.DataManager;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.weather.forecast.R;
import com.weather.forecast.manager.DataCallback;
import com.weather.forecast.model.CityData;
import com.weather.forecast.model.TemperatureData;
import com.weather.forecast.model.WeatherConditionData;
import com.weather.forecast.model.WeatherMainData;
import com.weather.forecast.model.WindData;
import com.weather.forecast.util.Cons;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Kiran Kumar Choudhary on 05,May,2019).
 */
public class DataProvider {

    private static DataProvider dataProvider;

    public static DataProvider getInstance() {
        return dataProvider != null ? dataProvider : (dataProvider = new DataProvider());
    }

    public void fetchWeatherData(final DataCallback dataCallback, final long cityId, final Context context) {
        new CommProvider().fetchWeatherData(new DataCallback() {
            @Override
            public void onResponse(ArrayList<WeatherMainData> weatherMainDataArrayList) {
                if (weatherMainDataArrayList != null && weatherMainDataArrayList.size() > 0) {
                    saveDataInPref(weatherMainDataArrayList, context);
                    dataCallback.onResponse(weatherMainDataArrayList);
                } else {
                    dataCallback.onFailure(context.getString(R.string.no_data));
                }
            }

            @Override
            public void onFailure(String message) {
                dataCallback.onFailure(message);
            }
        }, cityId);
    }

    public ArrayList<WeatherMainData> fetchWeatherDateFromCache(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        Gson gson = new Gson();
        String json = prefs.getString(Cons.PREF_KEY_WEATHER_DATA, null);
        Type type = new TypeToken<ArrayList<WeatherMainData>>() {
        }.getType();
        return gson.fromJson(json, type);
    }

    private void saveDataInPref(ArrayList<WeatherMainData> weatherMainDataArrayList, Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(weatherMainDataArrayList);
        editor.putString(Cons.PREF_KEY_WEATHER_DATA, json);
        editor.apply();
    }


    private void saveDataInDB(ArrayList<WeatherMainData> weatherMainDataArrayList, int cityId) {
        int tempId = 1;
        for (WeatherMainData weatherMainData : weatherMainDataArrayList) {
            TemperatureData temperatureData = weatherMainData.getTemperatureData();
            temperatureData.tempId = tempId;
            temperatureData.cityId = cityId;
            temperatureData.time = weatherMainData.getTimeStamp();
//            temperatureData.save();

            WeatherConditionData weatherConditionData = weatherMainData.getListWeatherConditionData().get(0);
            weatherConditionData.tempId = tempId;
//            weatherConditionData.save();

            WindData windData = weatherMainData.getWindData();
            windData.tempId = tempId;
//            windData.save();

        }

    }

    private ArrayList<WeatherMainData> getDataFromDB() {

        ArrayList<WeatherMainData> weatherMainDataArrayList = new ArrayList<>();
        CityData city = CityData.getCityByName("");

        ArrayList<TemperatureData> temperatureDataArrayList = (ArrayList<TemperatureData>) TemperatureData.getTemperatureDataByCityId(city.cityId);
        for (TemperatureData temperatureData : temperatureDataArrayList) {
            WeatherConditionData weatherConditionData = WeatherConditionData.getWeatherConditionDataByTempId(temperatureData.tempId);
            WindData windData = WindData.getWindDataByTempId(temperatureData.tempId);

            WeatherMainData weatherMainData = new WeatherMainData();
            weatherMainData.setTimeStamp(temperatureData.time);
            weatherMainData.temperatureData = temperatureData;
            weatherMainData.windData = windData;
            weatherMainData.listWeatherConditionData.add(weatherConditionData);

            weatherMainDataArrayList.add(weatherMainData);
        }
        return weatherMainDataArrayList;
    }

}
