package com.weather.forecast.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.weather.forecast.util.Cons;

import java.io.Serializable;

/**
 * Created by Kiran Kumar Choudhary on 05,May,2019).
 */

@Table(name = "Weather", id = "_id")
public class WeatherConditionData  implements Serializable {

    public static final String COL_MAIN = "Main";
    public static final String COL_DESCRIPTION = "Description";
    public static final String COL_ICON = "Icon";
    public static final String COL_TEMP_ID = "TempId";


    @SerializedName("main")
    @Column(name = COL_MAIN)
    @Expose
    private String main;

    @SerializedName("description")
    @Column(name = COL_DESCRIPTION)
    @Expose
    private String description;

    @SerializedName("icon")
    @Column(name = COL_ICON)
    @Expose
    private String url;

    @Column(name = COL_TEMP_ID)
    @Expose
    public int tempId;

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return String.format(Cons.IMAGE_URL, url);
    }

    public static WeatherConditionData getWeatherConditionDataByTempId(int tempId) {
//        return new Select().from(WeatherConditionData.class).where(COL_TEMP_ID + "=?", tempId).executeSingle();
        return null;
    }
}
