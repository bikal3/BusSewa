package com.example.bustracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bustracker.ui.BusLocationsActivity;
import com.example.bustracker.ui.BusRouteActivity;
import com.example.bustracker.ui.JobVacancyActivity;
import com.example.bustracker.ui.NewsActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnsignin, btnBusroute, btnlocation, btnnews, btnjobvacancy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnBusroute = findViewById(R.id.btn_busroute_main);
        btnjobvacancy = findViewById(R.id.btn_job_vacancy_main);
        btnlocation = findViewById(R.id.btn_bus_location_main);
        btnnews = findViewById(R.id.btn_news_main);

        btnnews.setOnClickListener(this);
        btnlocation.setOnClickListener(this);
        btnjobvacancy.setOnClickListener(this);
        btnBusroute.setOnClickListener(this);
        initToolbar();
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.trans_det_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("BusSewa");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_bus_location_main:
                Intent intent = new Intent(this, BusLocationsActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_busroute_main:
                Intent intent2 = new Intent(this, BusRouteActivity.class);
                startActivity(intent2);
                break;
            case R.id.btn_job_vacancy_main:
                Intent intent3 = new Intent(this, JobVacancyActivity.class);
                startActivity(intent3);
                break;
            case R.id.btn_news_main:
                Intent intent4 = new Intent(this, NewsActivity.class);
                startActivity(intent4);
                break;
        }
    }
}
