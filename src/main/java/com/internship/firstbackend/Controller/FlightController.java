package com.internship.firstbackend.Controller;

import com.internship.firstbackend.dbconnector.MongoConnector;
import com.internship.firstbackend.model.Airport;
import com.internship.firstbackend.model.Flight;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RestController
public class FlightController {
    private ArrayList<Flight> flightList;


    public FlightController(){
        flightList = new ArrayList<Flight>();

        /*
        List<Integer> sittingPlan = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            sittingPlan.add(0);
        }

        Flight flight1 = new Flight("flight1", "airport1", "airport2", 2.5F, "plane1", Calendar.getInstance(), sittingPlan);
        Flight flight2 = new Flight("flight2", "airport2", "airport3", 2.5F, "plane1", Calendar.getInstance(), sittingPlan);
        Flight flight3 = new Flight("flight3", "airport3", "airport1", 2.5F, "plane1", Calendar.getInstance(), sittingPlan);

        flightList.add(flight1);
        flightList.add(flight2);
        flightList.add(flight3);
         */
    }


    @GetMapping("/flights")
    public ArrayList<Flight> getAllFlights(){
        MongoConnector mongoConnection = new MongoConnector();
        flightList = mongoConnection.getFlights();
        mongoConnection.closeConnection();
        return flightList;
    }

    @GetMapping("/flight")
    public Flight getFlightById(@RequestParam(value = "id", defaultValue = "id1") String requestedFlightId){
        MongoConnector mongoConnection = new MongoConnector();
        Flight requestedFlight = mongoConnection.getFlightById(requestedFlightId);

        if(requestedFlight != null){
            return requestedFlight;
        }
        return null;
    }

    @PostMapping("/newflight")
    public Flight addFlight(@RequestBody Flight newFlight){
        MongoConnector mongoConnection = new MongoConnector();
        mongoConnection.addFlight(newFlight);
        return newFlight;
    }

}
