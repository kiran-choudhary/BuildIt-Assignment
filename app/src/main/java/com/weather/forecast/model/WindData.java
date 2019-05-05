package com.weather.forecast.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Kiran Kumar Choudhary on 05,May,2019).
 */
@Table(name = "Wind", id = "_id")
public class WindData  {

    public static final String COL_TEMP_ID = "TempId";
    public static final String COL_SPEED = "Speed";
    public static final String COL_DEG = "Deg";

    @SerializedName("speed")
    @Column(name = COL_SPEED)
    @Expose
    private float speed;

    @SerializedName("deg")
    @Column(name = COL_DEG)
    @Expose
    private float degree;

    @Column(name = COL_TEMP_ID)
    public int tempId;

    public float getSpeed() {
        return speed;
    }

    public float getDegree() {
        return degree;
    }

    public static WindData getWindDataByTempId(int tempId) {
//        return new Select().from(WindData.class).where(COL_TEMP_ID + "=?", tempId).executeSingle();
        return null;
    }

    public static void deleteWindData(){

    }

}
