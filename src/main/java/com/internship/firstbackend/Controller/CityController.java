package com.internship.firstbackend.Controller;

import com.internship.firstbackend.dbconnector.MongoConnector;
import com.internship.firstbackend.model.datamodels.City;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CityController {

    private ArrayList<City> cityList;
    private MongoConnector mongoConnection;

    public CityController(){
        cityList = new ArrayList<City>();
        mongoConnection = MongoConnector.Singleton();

    }

    @GetMapping("/citytest")
    public ArrayList<City> cityTest(){
        return cityList;

    }


    @GetMapping("/cities")
    public ArrayList<City> getAllCities(){
        cityList = mongoConnection.getCities();
        return cityList;
    }

    @GetMapping("/city")
    public City getCityById(@RequestParam(value = "id", defaultValue = "id1") String requestedCityId){
        City requestedCity = mongoConnection.getCityById(requestedCityId);

        if(requestedCity != null){
            return requestedCity;
        }
        return null;
    }

    @PostMapping("/newcity")
    public City addCity(@RequestBody City newCity){
        mongoConnection.addCity(newCity);
        return newCity;
    }

}
