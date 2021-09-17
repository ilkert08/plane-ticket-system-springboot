package com.internship.firstbackend.Controller;

import com.internship.firstbackend.model.Airport;
import com.internship.firstbackend.model.City;
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


    @GetMapping("/cities")
    public ArrayList<City> getAllAirports(){
        return cityList;
    }

    @GetMapping("/city")
    public City getCityById(@RequestParam(value = "id", defaultValue = "id1") String requestedCityId){
        for (int i = 0; i < cityList.size(); i++) {
            City currentCity = cityList.get(i);
            if(currentCity.getCityId().equals(requestedCityId)){
                return currentCity;
            }
        }
        return null;
    }

    @PostMapping("/newcity")
    public City addPlane(@RequestBody City newCity){
        cityList.add(newCity);
        return cityList.get(cityList.size() - 1);
    }


}
