package com.internship.firstbackend.model;

public class Airport {
    private String airportId;
    private String name;
    private String cityId;
    private String[] coordinate;

    public Airport(String airportId, String name, String cityId, String[] coordinate) {
        this.airportId = airportId;
        this.name = name;
        this.cityId = cityId;
        this.coordinate = coordinate;
    }

    public Airport(){

    }

    public String getAirportId() {
        return airportId;
    }

    public String getName() {
        return name;
    }

    public String getCityId() {
        return cityId;
    }

    public String[] getCoordinate() {
        return coordinate;
    }
}