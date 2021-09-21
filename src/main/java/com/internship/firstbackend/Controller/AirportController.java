package com.internship.firstbackend.Controller;
import com.internship.firstbackend.dbconnector.MongoConnector;
import com.internship.firstbackend.model.datamodels.Airport;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
public class AirportController {


    private ArrayList<Airport> airportList;
    private MongoConnector mongoConnection;

    public AirportController(){
        airportList = new ArrayList<Airport>();
        mongoConnection = MongoConnector.Singleton();

    }

    @GetMapping("/airporttest")
    public ArrayList<Airport> airpotTest(){
        return airportList;

    }


    @GetMapping("/airports")
    public ArrayList<Airport> getAllAirports(){
        airportList = mongoConnection.getAirports();
        return airportList;

    }

    @GetMapping("/airport")
    public Airport getAirportById(@RequestParam(value = "id", defaultValue = "id1") String requestedAirportId){
        Airport requestedAirport = mongoConnection.getAirportById(requestedAirportId);

        if(requestedAirport != null){
            return requestedAirport;
        }
        return null;
    }

    @PostMapping("/newairport")
    public Airport addAirport(@RequestBody Airport newAirport){
        mongoConnection.addAirport(newAirport);
        return newAirport;
    }

}
