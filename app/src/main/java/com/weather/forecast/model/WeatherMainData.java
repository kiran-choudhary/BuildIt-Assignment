package com.weather.forecast.model;

import android.text.format.DateFormat;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Kiran Kumar Choudhary on 05,May,2019).
 */
public class WeatherMainData implements Serializable {


    @SerializedName("dt")
    @Expose
    private long timeStamp;

    @SerializedName("main")
    @Expose
    public TemperatureData temperatureData;

    @SerializedName("weather")
    @Expose
    public List<WeatherConditionData> listWeatherConditionData= new ArrayList<>();

    @SerializedName("wind")
    @Expose
    public WindData windData;

    private boolean isHeader = false;

    private int date;

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getDate() {
        Calendar cal = Calendar.getInstance(Locale.ENGLISH);
        cal.setTimeInMillis(timeStamp * 1000L);
        return DateFormat.format("EEE, d MMM", cal).toString();
    }

    public String getTime() {
        Calendar cal = Calendar.getInstance(Locale.ENGLISH);
        cal.setTimeInMillis(timeStamp * 1000L);
        return DateFormat.format("hh:mm a", cal).toString();
    }

    public void setDatePart() {
        Calendar cal = Calendar.getInstance(Locale.ENGLISH);
        cal.setTimeInMillis(timeStamp * 1000L);
        date = cal.get(Calendar.DAY_OF_MONTH);
    }

    public int getDatePart() {
        return date;
    }

    public TemperatureData getTemperatureData() {
        return temperatureData;
    }

    public List<WeatherConditionData> getListWeatherConditionData() {
        return listWeatherConditionData;
    }

    public WindData getWindData() {
        return windData;
    }

    public boolean isHeader() {
        return isHeader;
    }

    public void setHeader(boolean header) {
        isHeader = header;
    }
}
