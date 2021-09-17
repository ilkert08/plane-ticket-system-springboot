package com.internship.firstbackend.Controller;

import com.internship.firstbackend.model.Flight;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;

@RestController
public class FlightController {
    private ArrayList<Flight> flightList;


    public FlightController(){
        flightList = new ArrayList<Flight>();

        int[] sittingPlan = new int[200];
        Flight flight1 = new Flight("flight1", "airport1", "airport2", 2.5F, "plane1", Calendar.getInstance(), sittingPlan);
        Flight flight2 = new Flight("flight2", "airport2", "airport3", 2.5F, "plane1", Calendar.getInstance(), sittingPlan);
        Flight flight3 = new Flight("flight3", "airport3", "airport1", 2.5F, "plane1", Calendar.getInstance(), sittingPlan);

        flightList.add(flight1);
        flightList.add(flight2);
        flightList.add(flight3);

    }


    @GetMapping("/flights")
    public ArrayList<Flight> getAllAirports(){
        return flightList;
    }

    @GetMapping("/flight")
    public Flight getFlightById(@RequestParam(value = "id", defaultValue = "id1") String requestedFlightId){
        for (int i = 0; i < flightList.size(); i++) {
            Flight currentFlight = flightList.get(i);
            if(currentFlight.getFlightId().equals(requestedFlightId)){
                return currentFlight;
            }
        }
        return null;
    }

    @PostMapping("/newflight")
    public Flight addPlane(@RequestBody Flight newFlight){
        flightList.add(newFlight);
        return flightList.get(flightList.size() - 1);
    }

}
