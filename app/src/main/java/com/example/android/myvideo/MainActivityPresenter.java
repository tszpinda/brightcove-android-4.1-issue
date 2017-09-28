package com.example.android.myvideo;

import android.content.Context;
import android.content.Intent;

import com.example.android.recycleview.ListActivity;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivityPresenter {

    private final MainActivity view;
    private final Context ctx;

    public MainActivityPresenter(MainActivity view, Context ctx) {
        this.view = view;
        this.ctx = ctx;
    }

    public void changeDate(Warning warning) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 13);
        DateFormat timeFormat = android.text.format.DateFormat.getTimeFormat(ctx);
        warning.setTime12h(timeFormat.format(c.getTime()) + "PM");
        warning.setTime24h(timeFormat.format(c.getTime()));
    }

    public void openAnother(Context ctx) {
        Intent myIntent = new Intent(ctx, ListActivity.class);
        ctx.startActivity(myIntent);
    }

}
