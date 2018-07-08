package pl.exaco.internship.android.weatherdemo.ui.forecast;

import java.util.List;

import pl.exaco.internship.android.weatherdemo.model.City;
import pl.exaco.internship.android.weatherdemo.model.CityWeather;

public interface ForecastContract {

    interface Presenter {
        void getForecast(int id);
    }

    interface View {
        void onSuccess(List<CityWeather> data);

        void onFailure();

    }
}
