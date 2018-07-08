package pl.exaco.internship.android.weatherdemo.service.impl;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;

import java.util.ArrayList;
import java.util.List;

import pl.exaco.internship.android.weatherdemo.model.City;
import pl.exaco.internship.android.weatherdemo.model.CityWeather;
import pl.exaco.internship.android.weatherdemo.model.FutureWeather;
import pl.exaco.internship.android.weatherdemo.service.IForecastManager;
import pl.exaco.internship.android.weatherdemo.service.RequestCallback;
import pl.exaco.internship.android.weatherdemo.service.api.WeatherApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@EBean(scope = EBean.Scope.Singleton)
public class ForecastManager extends BaseManager implements IForecastManager{

    private WeatherApi api;
    @AfterInject

    void initService() {
        api = retrofit.create(WeatherApi.class);
    }

    @Override
    public void getForecastForCity(int id, RequestCallback<List<CityWeather>> callback) {
        api.getForecastWeather(String.valueOf(id)).enqueue(new Callback<FutureWeather>() {
            @Override
            public void onResponse(Call<FutureWeather> call, Response<FutureWeather> response) {
                if (null != response && response.body() != null) {
                    callback.onSuccess(response.body().getList());
                } else {
                    callback.onSuccess(new ArrayList<>());
                }
            }

            @Override
            public void onFailure(Call<FutureWeather> call, Throwable t) {
                callback.onError(t);
            }
        });

    }
}
