package pl.exaco.internship.android.weatherdemo.ui.weather;

import java.util.List;

import pl.exaco.internship.android.weatherdemo.model.CityWeather;

public interface WeatherContract {

	interface Presenter {
		void getWeather();

	}

	interface View {
		void onSuccess(List<CityWeather> data);

		void onFailure();
	}
}
