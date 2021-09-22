package com.internship.firstbackend.model.datamodels;

import java.util.Arrays;
import java.util.List;

public class Airport {
    private String airportId;
    private String name;
    private String cityId;
    private List<Double> coordinate;

    public Airport(String airportId, String name, String cityId, List<Double> coordinate) {
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

    public List<Double> getCoordinate() {
        return coordinate;
    }


    public void setAirportId(String airportId) {
        this.airportId = airportId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public void setCoordinate(List<Double> coordinate) {
        this.coordinate = coordinate;
    }


    @Override
    public String toString() {
        return "Airport{" +
                "airportId='" + airportId + '\'' +
                ", name='" + name + '\'' +
                ", cityId='" + cityId + '\'' +
                ", coordinate=" + coordinate +
                '}';
    }
}