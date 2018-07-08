package pl.exaco.internship.android.weatherdemo.ui.forecast;

import java.util.List;

import pl.exaco.internship.android.weatherdemo.model.City;
import pl.exaco.internship.android.weatherdemo.model.CityWeather;
import pl.exaco.internship.android.weatherdemo.service.IForecastManager;
import pl.exaco.internship.android.weatherdemo.service.IServiceFactory;
import pl.exaco.internship.android.weatherdemo.service.RequestCallback;

public class ForecastPresenter implements ForecastContract.Presenter {

    private final ForecastContract.View view;
    private final IForecastManager forecastManager;
    public ForecastPresenter(ForecastContract.View view, IServiceFactory serviceFactory){
        this.view=view;
        this.forecastManager=serviceFactory.getForecastManager();
    }
    @Override
    public void getForecast(int id) {
        forecastManager.getForecastForCity(id, new RequestCallback<List<CityWeather>>() {
            @Override
            public void onSuccess(List<CityWeather> data) {
                view.onSuccess(data);
            }

            @Override
            public void onError(Throwable throwable) {
                view.onFailure();
            }
        });
    }
}
