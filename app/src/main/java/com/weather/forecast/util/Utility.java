package com.weather.forecast.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;

/**
 * Created by Kiran Kumar Choudhary on 05,May,2019).
 */
public class Utility {

    public static boolean isConnectionAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            return true;
        }
        return false;
    }

    public static void saveLUT(SharedPreferences sharedPreferences, long time){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(Cons.PREF_KEY_LUT, time);
        editor.apply();
    }

    public static long getLUT(SharedPreferences sharedPreferences) {
        return sharedPreferences.getLong(Cons.PREF_KEY_LUT, 0L);
    }



}
