package com.internship.firstbackend.Controller;
import com.internship.firstbackend.dbconnector.MongoConnector;
import com.internship.firstbackend.model.Airport;
import com.internship.firstbackend.model.City;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AirportController {


    private ArrayList<Airport> airportList;

    public AirportController(){
        airportList = new ArrayList<Airport>();


        /*
        List<String> arr = new ArrayList<>();
        arr.add("30");
        arr.add("40");
        Airport airport1 = new Airport("id1", "Sabiha Gökçen Havalimanı", "34", arr);
        Airport airport2 = new Airport("id2", "Atatürk Havalimanı", "34", arr);
        Airport airport3 = new Airport("id3", "Büyük Istanbul Havalimanı", "34", arr);

        airportList.add(airport1);
        airportList.add(airport2);
        airportList.add(airport3);
        */

    }

    @GetMapping("/airporttest")
    public ArrayList<Airport> airpotTest(){
        return airportList;

    }


    @GetMapping("/airports")
    public ArrayList<Airport> getAllAirports(){
        MongoConnector mongoConnection = new MongoConnector();
        airportList = mongoConnection.getAirports();
        mongoConnection.closeConnection();
        return airportList;

    }

    @GetMapping("/airport")
    public Airport getAirportById(@RequestParam(value = "id", defaultValue = "id1") String requestedAirportId){
        MongoConnector mongoConnection = new MongoConnector();
        Airport requestedAirport = mongoConnection.getAirportById(requestedAirportId);

        if(requestedAirport != null){
            return requestedAirport;
        }
        return null;
    }

    @PostMapping("/newairport")
    public Airport addAirport(@RequestBody Airport newAirport){
        MongoConnector mongoConnection = new MongoConnector();
        mongoConnection.addAirport(newAirport);
        return newAirport;
    }

}
