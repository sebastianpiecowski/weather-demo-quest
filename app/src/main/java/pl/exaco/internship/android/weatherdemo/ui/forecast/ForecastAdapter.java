package pl.exaco.internship.android.weatherdemo.ui.forecast;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import pl.exaco.internship.android.weatherdemo.R;
import pl.exaco.internship.android.weatherdemo.databinding.ItemForecastBinding;
import pl.exaco.internship.android.weatherdemo.model.CityWeather;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder> {

    private final List<CityWeather> items = new ArrayList<>();
    private final Context context;

    ForecastAdapter(Context context){
        this.context=context;
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
    public ForecastViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        final View itemView = LayoutInflater.from(context).inflate(R.layout.item_forecast, parent, false);
        return new ForecastViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(ForecastAdapter.ForecastViewHolder holder, int position) {
        if (getItemCount() > position) {
            final CityWeather weather = items.get(position);
            holder.binData(weather);
        }
    }
    public class ForecastViewHolder extends RecyclerView.ViewHolder{

       // ItemForecastBinding binding;

        public  ForecastViewHolder(View itemView){
            super(itemView);

           // binding= DataBindingUtil.bind(itemView);

        }

        void binData(CityWeather data) {
         //   binding.setCityWeather(data);
          //  binding.setDescription(data.getCityWeather().get(0));
        }
    }
}
