package com.internship.firstbackend.Controller;

import com.internship.firstbackend.dbconnector.MongoConnector;
import com.internship.firstbackend.model.Airport;
import com.internship.firstbackend.model.City;
import com.internship.firstbackend.model.Plane;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CityController {

    private ArrayList<City> cityList;


    public CityController(){
        cityList = new ArrayList<City>();

        String[] arr = {"30", "40"};

        City city1 = new City("34", "İstanbul", "Türkiye");
        City city2 = new City("35", "İzmir", "Türkiye");
        City city3 = new City("55", "Samsun","Türkiye");

        cityList.add(city1);
        cityList.add(city2);
        cityList.add(city3);

    }

    @GetMapping("/citytest")
    public ArrayList<City> cityTest(){
        return cityList;

    }


    @GetMapping("/cities")
    public ArrayList<City> getAllCities(){
        MongoConnector mongoConnection = new MongoConnector();
        cityList = mongoConnection.getCities();
        mongoConnection.closeConnection();
        return cityList;
    }

    @GetMapping("/city")
    public City getCityById(@RequestParam(value = "id", defaultValue = "id1") String requestedCityId){
        MongoConnector mongoConnection = new MongoConnector();
        City requestedCity = mongoConnection.getCityById(requestedCityId);

        if(requestedCity != null){
            return requestedCity;
        }
        return null;
    }

    @PostMapping("/newcity")
    public City addCity(@RequestBody City newCity){
        MongoConnector mongoConnection = new MongoConnector();
        mongoConnection.addCity(newCity);
        return newCity;
    }

}
