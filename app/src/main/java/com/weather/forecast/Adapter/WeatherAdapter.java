package com.weather.forecast.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;
import com.weather.forecast.R;
import com.weather.forecast.model.WeatherMainData;
import com.weather.forecast.util.MeasurementUnitType;

import java.util.ArrayList;


/**
 * Created by Kiran Kumar Choudhary on 05,May,2019).
 */

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.CustomViewHolder> {

    private ArrayList<WeatherMainData> dataList;
    private Context context;

    public WeatherAdapter(Context context, ArrayList<WeatherMainData> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        private TextView dateTextView, timeTextView, weatherStatusTextView, currentTempTextView, minMaxTempTextView;
        private ImageView weatherImageView;
        private View headerView, contentView;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            dateTextView = mView.findViewById(R.id.date_textview);
            timeTextView = mView.findViewById(R.id.time_textview);
            weatherStatusTextView = mView.findViewById(R.id.weather_status);
            currentTempTextView = mView.findViewById(R.id.current_temp_textview);
            minMaxTempTextView = mView.findViewById(R.id.min_max_temp_textview);
            weatherImageView = mView.findViewById(R.id.weather_image);
            contentView = mView.findViewById(R.id.rl_content);
            headerView = mView.findViewById(R.id.ll_date);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.weather_tupple, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        WeatherMainData weatherMainData = dataList.get(position);
        if (weatherMainData.isHeader()) {
            holder.dateTextView.setText(weatherMainData.getDate());
            holder.headerView.setVisibility(View.VISIBLE);
            holder.contentView.setVisibility(View.GONE);
        } else {
            holder.headerView.setVisibility(View.GONE);
            holder.contentView.setVisibility(View.VISIBLE);

            holder.timeTextView.setText(weatherMainData.getTime() + "");
            holder.weatherStatusTextView.setText(weatherMainData.getListWeatherConditionData().get(0).getDescription());
            holder.currentTempTextView.setText(weatherMainData.getTemperatureData().getTemperatureFormat(weatherMainData.getTemperatureData().getTemperature()));
            holder.minMaxTempTextView.setText(weatherMainData.getTemperatureData().getTemperatureFormat(weatherMainData.getTemperatureData().getMinTemperature()));

            Picasso.Builder builder = new Picasso.Builder(context);
            builder.downloader(new OkHttp3Downloader(context));
            builder.build().load(weatherMainData.getListWeatherConditionData().get(0).getUrl())
                    .into(holder.weatherImageView);

        }

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
