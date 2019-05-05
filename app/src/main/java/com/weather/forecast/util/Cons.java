package com.weather.forecast.util;

/**
 * Created by Kiran Kumar Choudhary on 05,May,2019).
 */
public class Cons {

    public static String IMAGE_URL = "http://openweathermap.org/img/w/%s.png";
    public static final String BASE_URL = "http://api.openweathermap.org/";
    public static String FORECAST_API = "data/2.5/forecast?id=%s&APPID=" + Cons.APP_ID + "&units=metric";
    public static final String APP_ID = "570c11ea13960ff7242bcc1698925d1e";
    public static final String PREF_KEY_WEATHER_DATA = "weather_data";
    public static final String PREF_KEY_LUT = "LUT";
    public static final int CACHE_PERIOD = 3 * 60 * 60 * 1000;


}
