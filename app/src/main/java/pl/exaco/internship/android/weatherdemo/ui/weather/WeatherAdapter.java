package pl.exaco.internship.android.weatherdemo.ui.weather;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import pl.exaco.internship.android.weatherdemo.R;
import pl.exaco.internship.android.weatherdemo.databinding.ItemWeatherBinding;
import pl.exaco.internship.android.weatherdemo.model.CityWeather;
import pl.exaco.internship.android.weatherdemo.ui.forecast.ForecastActivity;
import pl.exaco.internship.android.weatherdemo.ui.forecast.ForecastActivity_;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {

    private final List<CityWeather> items = new ArrayList<>();
    private final Context context;

    WeatherAdapter(Context context) {
        this.context = context;
    }

    void setItems(@NonNull List<CityWeather> items) {
        this.items.clear();
        this.items.addAll(items);
        this.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(context).inflate(R.layout.item_weather, parent, false);
        return new WeatherViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WeatherViewHolder holder, int position) {
        if (getItemCount() > position) {
            final CityWeather weather = items.get(position);
            holder.binData(weather);
        }
    }

    class WeatherViewHolder extends RecyclerView.ViewHolder {

        ItemWeatherBinding binding;

        public WeatherViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);

            itemView.setOnClickListener((View v) -> {
                //Log.i("id_clicked", String.valueOf(selectedCity.getId()));
                ForecastActivity_.intent(itemView.getContext()).extra("id", items.get(getAdapterPosition()).getId()).start();
            });
        }

        void binData(CityWeather data) {
            binding.setCityWeather(data);
            binding.setDescription(data.getCityWeather().get(0));
        }
    }
}
