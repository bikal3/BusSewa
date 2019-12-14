package com.example.bustracker.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.bustracker.R;
import com.example.bustracker.adapters.BusRouteAdapter;
import com.example.bustracker.impl.BusRouteImpl;
import com.example.bustracker.models.BusRouteModel;
import com.example.bustracker.utils.Helper;

import java.util.ArrayList;
import java.util.List;

public class BusRouteActivity extends AppCompatActivity {
    private BusRouteImpl busRouteImpl;
    private List<BusRouteModel> busRouteModelList;
    private RecyclerView busrouterecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bus_route);
        busRouteImpl=new BusRouteImpl();
        busRouteModelList=new ArrayList<>();

        busrouterecycler=findViewById(R.id.bus_route_recycler);
        busrouterecycler.setLayoutManager(new LinearLayoutManager(this));
        getbusroutelist();

    }

    private void getbusroutelist() {
        Helper.StrictMode();
        busRouteModelList=busRouteImpl.getBusRoute();
        BusRouteAdapter busRouteAdapter=new BusRouteAdapter(this,busRouteModelList);
        busrouterecycler.setAdapter(busRouteAdapter);
    }
}
