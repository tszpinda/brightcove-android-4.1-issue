package com.example.android.recycleview;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Observable;

public class ForecastViewModel extends Observable {

    private final Context context;
    private List<Forecast> data;

    ForecastViewModel(@NonNull Context context) {
        this.context = context;
        data = Collections.emptyList();
    }

    public void onCreate() {
        mimicLoadDataAfterDelay(4000, new Forecast("Mon", 24), new Forecast("Tue", 27));
        mimicLoadDataAfterDelay(10000, new Forecast("Mon", 26), new Forecast("Tue", 29));
        mimicLoadDataAfterDelay(13000, new Forecast("Mon", 30), new Forecast("Tue", 10));
    }


    private void mimicLoadDataAfterDelay(int delay, final Forecast... forecasts) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                data = Arrays.asList(forecasts);
                setChanged();
                notifyObservers();
            }

        }, delay);
    }

    public List<Forecast> getForecastList() {
        return data;
    }
}
