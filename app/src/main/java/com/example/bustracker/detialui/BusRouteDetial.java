package com.example.bustracker.detialui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.TextView;

import com.example.bustracker.R;
import com.example.bustracker.impl.BusRouteImpl;
import com.example.bustracker.models.BusRouteModel;
import com.example.bustracker.response.BusRouteResponse;
import com.example.bustracker.utils.Helper;

public class BusRouteDetial extends AppCompatActivity {
    private TextView route, startlocation, endlocation, substart, subend;
    private String id = "";
    private BusRouteImpl busRouteImpl;
    private BusRouteModel busRouteModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.busroute_main);
        route = findViewById(R.id.txt_route_br);
        startlocation = findViewById(R.id.txt_start_route_br);
        endlocation = findViewById(R.id.txt_end_route_br);
        substart = findViewById(R.id.txt_start_subroute_br);
        subend = findViewById(R.id.txt_return_subroute_br);

        busRouteImpl = new BusRouteImpl();
        id = getIntent().getStringExtra("id");
        getBusrouteDetail();
        initToolbar();
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.trans_det_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Bus Route Details");
    }


    private void getBusrouteDetail() {
        Helper.StrictMode();
        BusRouteResponse busRouteResponse = busRouteImpl.getBusRoute(id);
        if (!id.equals("")) {
            busRouteModel = busRouteResponse.getBusroute();
            populateDetails(busRouteModel);
        }
    }

    private void populateDetails(BusRouteModel busRouteModel) {
        route.setText(busRouteModel.getRoute());
        startlocation.setText(busRouteModel.getStart_location());
        endlocation.setText(busRouteModel.getEnd_location());
        subend.setText(busRouteModel.getReturning_sub_route());
        substart.setText(busRouteModel.getStarting_sub_route());
    }
}
