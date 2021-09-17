package com.internship.firstbackend.model;

public class City {

    private String cityId;
    private String name;
    private String country;

    public City(String cityId, String name, String country) {
        this.cityId = cityId;
        this.name = name;
        this.country = country;
    }

    public City(){

    }

    public String getCityId() {
        return cityId;
    }


    public String getName() {
        return name;
    }


    public String getCountry() {
        return country;
    }

}
