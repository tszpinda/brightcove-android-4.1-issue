package com.example.android.myvideo;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;


import com.example.android.R;
import com.example.android.databinding.ActivityMainBinding;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        MainActivityPresenter mainActivityPresenter = new MainActivityPresenter(this, getApplicationContext());
        Warning warning = new Warning();
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setWarning(warning);
        binding.setPresenter(mainActivityPresenter);

        super.onCreate(savedInstanceState);

    }


}
