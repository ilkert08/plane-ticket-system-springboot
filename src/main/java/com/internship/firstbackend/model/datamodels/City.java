package com.internship.firstbackend.model.datamodels;

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

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId='" + cityId + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
