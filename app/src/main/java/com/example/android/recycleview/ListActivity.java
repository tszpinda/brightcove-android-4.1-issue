package com.example.android.recycleview;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.R;
import com.example.android.databinding.ListActivityBinding;

import java.util.Observable;
import java.util.Observer;

public class ListActivity extends AppCompatActivity implements Observer {

    private ListActivityBinding listDataBinding;
    private ForecastViewModel forecastViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initDataBinding();

        setupList(listDataBinding.forecastListRecyclerView);
        setupObserver(forecastViewModel);
        forecastViewModel.onCreate();
    }

    private void setupList(RecyclerView forecastListRecyclerView) {
        ForecastItemAdaptor adapter = new ForecastItemAdaptor();
        forecastListRecyclerView.setAdapter(adapter);
        forecastListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initDataBinding() {
        listDataBinding = DataBindingUtil.setContentView(this, R.layout.list_activity);
        forecastViewModel = new ForecastViewModel(this);
        listDataBinding.setForecastViewModel(forecastViewModel);
    }


    public void setupObserver(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object o) {
        if (observable instanceof ForecastViewModel) {
            ForecastViewModel viewModel = (ForecastViewModel) observable;

            ForecastItemAdaptor adapter = (ForecastItemAdaptor) listDataBinding.forecastListRecyclerView.getAdapter();
            adapter.setData(viewModel.getForecastList());
        }
    }
}
