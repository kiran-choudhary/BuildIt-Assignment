package com.weather.forecast.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.query.Select;
import com.google.gson.annotations.Expose;

/**
 * Created by Kiran Kumar Choudhary on 05,May,2019).
 */
public class CityData extends Model {

    public static final String COL_CITY_ID = "Cityid";
    public static final String COL_CITY_NAME = "Cityname";

    @Column(name = COL_CITY_ID)
    @Expose
    public int cityId;

    @Column(name = COL_CITY_NAME)
    @Expose
    private int cityName;

    public static CityData getCityByName(String name){
        return new Select().from(CityData.class).where(COL_CITY_NAME +"=?",name).executeSingle();
    }

}
