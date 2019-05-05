package com.weather.forecast.DataManager;

import com.weather.forecast.manager.DataCallback;
import com.weather.forecast.model.WeatherResponseData;
import com.weather.forecast.network.GetWeatherDataService;
import com.weather.forecast.network.RetrofitClientInstance;
import com.weather.forecast.util.Cons;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Kiran Kumar Choudhary on 05,May,2019).
 */
public class CommProvider {

    public void fetchWeatherData(final DataCallback dataCallback, long cityId) {
        GetWeatherDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetWeatherDataService.class);
        Call<WeatherResponseData> call = service.getWeatherData(Cons.BASE_URL + String.format(Cons.FORECAST_API, cityId));
        call.enqueue(new Callback<WeatherResponseData>() {
            @Override
            public void onResponse(Call<WeatherResponseData> call, Response<WeatherResponseData> response) {
                dataCallback.onResponse(response.body().getWeatherMainDataList());
            }

            @Override
            public void onFailure(Call<WeatherResponseData> call, Throwable t) {
                dataCallback.onFailure(t.getMessage());
            }
        });

    }

}
