package pl.exaco.internship.android.weatherdemo.service;

import java.util.List;

import pl.exaco.internship.android.weatherdemo.model.City;
import pl.exaco.internship.android.weatherdemo.model.CityWeather;

public interface IForecastManager {

    void getForecastForCity(City city, RequestCallback<List<CityWeather>> callback);
}
