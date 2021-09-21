package com.internship.firstbackend.Controller;

import com.internship.firstbackend.dbconnector.MongoConnector;
import com.internship.firstbackend.model.datamodels.Flight;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class FlightController {
    private ArrayList<Flight> flightList;
    private MongoConnector mongoConnection;

    public FlightController(){
        flightList = new ArrayList<Flight>();
        mongoConnection = MongoConnector.Singleton();

    }


    @GetMapping("/flights")
    public ArrayList<Flight> getAllFlights(){
        flightList = mongoConnection.getFlights();
        return flightList;
    }

    @GetMapping("/flight")
    public Flight getFlightById(@RequestParam(value = "id", defaultValue = "id1") String requestedFlightId){
        Flight requestedFlight = mongoConnection.getFlightById(requestedFlightId);

        if(requestedFlight != null){
            return requestedFlight;
        }
        return null;
    }

    @PostMapping("/newflight")
    public Flight addFlight(@RequestBody Flight newFlight){
        mongoConnection.addFlight(newFlight);
        return newFlight;
    }

}
