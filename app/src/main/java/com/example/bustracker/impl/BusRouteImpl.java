package com.example.bustracker.impl;

import com.example.bustracker.api.APIs;
import com.example.bustracker.models.BusRouteModel;
import com.example.bustracker.models.NewsModel;
import com.example.bustracker.response.BusRouteResponse;
import com.example.bustracker.response.NewsResponse;
import com.example.bustracker.utils.RetrofitClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class BusRouteImpl {
    private Gson gson;
    private APIs busRouteApi;

    public BusRouteImpl() {

        busRouteApi = RetrofitClient.getInstance().create(APIs.class);
        gson = new GsonBuilder().create();
    }

    public List<BusRouteModel> getBusRoute() {
        List<BusRouteModel> busroute = new ArrayList<>();
        Call<BusRouteResponse> busRouteCall = busRouteApi.fetchbusRoute();
        try {
            Response<BusRouteResponse> busRouteResponse = busRouteCall.execute();
            if (!busRouteResponse.isSuccessful()) {
                return busroute;
            } else if (busRouteResponse.body().getBusroutes() != null) {
                busroute = busRouteResponse.body().getBusroutes();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return busroute;

    }

    public BusRouteResponse getBusRoute(String id) {
        BusRouteResponse busroute = null;
        Call<BusRouteResponse> busRouteCall = busRouteApi.fetchsingbusRoute(id);
        try {
            Response<BusRouteResponse> busRouteResponse = busRouteCall.execute();
            if (!busRouteResponse.isSuccessful()) {
                return busroute;
            }
            busroute = busRouteResponse.body();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return busroute;

    }
}
