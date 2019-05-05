package com.weather.forecast.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.weather.forecast.util.MeasurementUnitType;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Kiran Kumar Choudhary on 05,May,2019).
 */
@Table(name = "Temperature")
public class TemperatureData implements Serializable {

    public static final String COL_TEMP = "temp";
    public static final String COL_MIN_TEMP = "Mintemp";
    public static final String COL_MAX_TEMP = "Maxtemp";
    public static final String COL_PRESSURE = "Pressure";
    public static final String COL_SEA_LEVEL = "Sealevel";
    public static final String COL_GRND_LEVEL = "Grandlevel";
    public static final String COL_HUMIDITY = "Humidity";
    public static final String COL_CITY_ID = "Cityid";
    public static final String COL_TEMP_ID = "TempId";
    public static final String COL_TIME = "Time";


    @SerializedName("temp")
    @Column(name = COL_TEMP)
    @Expose
    private float temperature;

    @SerializedName("temp_min")
    @Column(name = COL_MIN_TEMP)
    @Expose
    private float minTemperature;

    @SerializedName("temp_max")
    @Column(name = COL_MAX_TEMP)
    @Expose
    private float maxTemperature;

    @SerializedName("pressure")
    @Column(name = COL_PRESSURE)
    @Expose
    private float pressure;

    @SerializedName("sea_level")
    @Column(name = COL_SEA_LEVEL)
    @Expose
    private float seaLevelPressure;

    @SerializedName("grnd_level")
    @Column(name = COL_GRND_LEVEL)
    @Expose
    private float groundLevelPressure;

    @SerializedName("humidity")
    @Column(name = COL_HUMIDITY)
    @Expose
    private float humidity;

    @Column(name = COL_CITY_ID)
    @Expose
    public int cityId;

    @Column(name = COL_TEMP_ID)
    @Expose
    public int tempId;

    @Column(name = COL_TIME)
    @Expose
    public long time;

    public float getTemperature() {
        return temperature;
    }

    public float getMinTemperature() {
        return minTemperature;
    }

    public float getMaxTemperature() {
        return maxTemperature;
    }

    public float getPressure() {
        return pressure;
    }

    public float getSeaLevelPressure() {
        return seaLevelPressure;
    }

    public float getGroundLevelPressure() {
        return groundLevelPressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public String getTemperatureFormat(float temperature){
        return String.format("%.01f",temperature) + MeasurementUnitType.Celsius.getSymbol();
    }

    public static List<TemperatureData> getTemperatureDataByCityId(int cityId){
//        return new Select().from(TemperatureData.class).where(COL_CITY_ID +"=?",cityId).execute();
        return null;
    }

}
