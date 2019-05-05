package com.weather.forecast.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.weather.forecast.Adapter.WeatherAdapter;
import com.weather.forecast.R;
import com.weather.forecast.manager.WeatherViewInteractor;
import com.weather.forecast.model.WeatherMainData;
import com.weather.forecast.presenter.WeatherPresenter;

import java.util.ArrayList;


/**
 * Created by Kiran Kumar Choudhary on 05,May,2019).
 */
public class WeatherActivity extends AppCompatActivity implements WeatherViewInteractor {

    private WeatherPresenter weatherPresenter = null;
    private RecyclerView weatherList;
    private WeatherAdapter weatherAdapter = null;
    private long cityId = 1253986;
    private ProgressBar progressBar;
    private TextView textViewError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weater_view);
        weatherList = findViewById(R.id.weather_list);
        progressBar = findViewById(R.id.progress_circular);
        textViewError = findViewById(R.id.error_textview);

        weatherList.addItemDecoration(new DividerItemDecoration(weatherList.getContext(), DividerItemDecoration.VERTICAL));
        weatherPresenter = new WeatherPresenter(this);
        weatherPresenter.loadWeatherData(cityId, this);
    }

    @Override
    public void onUpdateData(ArrayList<WeatherMainData> weatherMainDataArrayList) {
        progressBar.setVisibility(View.GONE);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        weatherList.setLayoutManager(layoutManager);
        weatherAdapter = new WeatherAdapter(this, weatherMainDataArrayList);
        weatherList.setAdapter(weatherAdapter);
    }

    @Override
    public void onError(String message) {
        progressBar.setVisibility(View.GONE);
        textViewError.setVisibility(View.VISIBLE);
        textViewError.setText(message);
    }
}
