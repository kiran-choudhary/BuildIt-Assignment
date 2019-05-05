package com.weather.forecast.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.weather.forecast.DataManager.DataProvider;
import com.weather.forecast.R;
import com.weather.forecast.manager.DataCallback;
import com.weather.forecast.manager.WeatherViewInteractor;
import com.weather.forecast.model.WeatherMainData;
import com.weather.forecast.util.Cons;
import com.weather.forecast.util.Utility;

import java.util.ArrayList;

/**
 * Created by Kiran Kumar Choudhary on 05,May,2019).
 */
public class WeatherPresenter {

    private WeatherViewInteractor weatherViewInteractor = null;

    public WeatherPresenter(WeatherViewInteractor weatherViewInteractor) {
        this.weatherViewInteractor = weatherViewInteractor;
    }

    public void loadWeatherData(long cityId, final Context context) {

        if (isDataValidInCache(context)) {
            ArrayList<WeatherMainData> arrayListWeatherMainData = DataProvider.getInstance().fetchWeatherDateFromCache(context);
            weatherViewInteractor.onUpdateData(prepareDataForUI(arrayListWeatherMainData));
            return;
        }

        if (!Utility.isConnectionAvailable(context)) {
            weatherViewInteractor.onError(context.getString(R.string.no_internet));
            return;
        }


        DataProvider.getInstance().fetchWeatherData(new DataCallback() {
            @Override
            public void onResponse(ArrayList<WeatherMainData> arrayListWeatherMainData) {
                Utility.saveLUT(PreferenceManager.getDefaultSharedPreferences(context), System.currentTimeMillis());
                weatherViewInteractor.onUpdateData(prepareDataForUI(arrayListWeatherMainData));
            }

            @Override
            public void onFailure(String message) {
                weatherViewInteractor.onError(message);
            }
        }, cityId, context);

    }

    public ArrayList<WeatherMainData> prepareDataForUI(ArrayList<WeatherMainData> arrayListWeatherMainData) {
        ArrayList arrayList = new ArrayList();
        ArrayList<WeatherMainData> arrayListWeatherMainDataWithGroupByDate = new ArrayList<>();


        for (WeatherMainData weatherMainData : arrayListWeatherMainData) {
            weatherMainData.setDatePart();
            if (!arrayList.contains(weatherMainData.getDatePart())) {
                WeatherMainData weatherMainDataHeader = new WeatherMainData();
                weatherMainDataHeader.setTimeStamp(weatherMainData.getTimeStamp());
                weatherMainDataHeader.setHeader(true);
                arrayListWeatherMainDataWithGroupByDate.add(weatherMainDataHeader);
                arrayList.add(weatherMainData.getDatePart());
            }
            arrayListWeatherMainDataWithGroupByDate.add(weatherMainData);
        }

        return arrayListWeatherMainDataWithGroupByDate;
    }

    private boolean isDataValidInCache(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return (prefs.contains(Cons.PREF_KEY_LUT) && (System.currentTimeMillis() - Utility.getLUT(PreferenceManager.getDefaultSharedPreferences(context))) < Cons.CACHE_PERIOD);
    }
}
