package pl.exaco.internship.android.weatherdemo.ui.forecast;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.BindingObject;
import org.androidannotations.annotations.DataBound;
import org.androidannotations.annotations.EActivity;

import java.util.List;

import pl.exaco.internship.android.weatherdemo.R;
import pl.exaco.internship.android.weatherdemo.databinding.ActivityForecastBinding;
import pl.exaco.internship.android.weatherdemo.model.CityWeather;
import pl.exaco.internship.android.weatherdemo.service.IServiceFactory;
import pl.exaco.internship.android.weatherdemo.service.impl.ServiceFactory;

@DataBound
@EActivity(R.layout.activity_forecast)
public class ForecastActivity extends AppCompatActivity implements ForecastContract.View {

    @Bean(ServiceFactory.class)
    IServiceFactory serviceFactory;

    @BindingObject
    ActivityForecastBinding binding;

    private ForecastAdapter adapter;
    private ForecastContract.Presenter presenter;


    @AfterViews
    void viewCreated() {
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ForecastAdapter(this);
        binding.recyclerView.setAdapter(adapter);
        presenter = new ForecastPresenter(this, serviceFactory);
        getData(0);

    }

    private void getData(int id) {
        binding.progressBar.setVisibility(View.VISIBLE);
        presenter.getForecast(id);
    }

    @Override
    public void onSuccess(List<CityWeather> data) {
        binding.progressBar.setVisibility(View.GONE);
        if (data != null && !data.isEmpty()) {
            binding.recyclerView.setVisibility(View.VISIBLE);
            adapter.setItems(data);
        } else {
            binding.noData.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onFailure() {
        binding.progressBar.setVisibility(View.GONE);
        binding.noData.setVisibility(View.VISIBLE);
        binding.noData.setText(R.string.download_error);
    }
}
