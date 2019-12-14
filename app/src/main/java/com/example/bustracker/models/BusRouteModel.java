package com.example.bustracker.models;

public class BusRouteModel {
    private String id,route,start_location,end_location,starting_sub_route,returning_sub_route;

    public String getId() {
        return id;
    }

    public String getRoute() {
        return route;
    }

    public String getStart_location() {
        return start_location;
    }

    public String getEnd_location() {
        return end_location;
    }

    public String getStarting_sub_route() {
        return starting_sub_route;
    }

    public String getReturning_sub_route() {
        return returning_sub_route;
    }
}
