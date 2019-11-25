package com.example.bustracker.response;

import com.example.bustracker.models.BusRouteModel;

import java.util.List;

public class BusRouteResponse {
    private List<BusRouteModel> busroutes;
    private BusRouteModel busroute;
    private String message;

    public List<BusRouteModel> getBusroutes() {
        return busroutes;
    }

    public BusRouteModel getBusroute() {
        return busroute;
    }

    public String getMessage() {
        return message;
    }
}
