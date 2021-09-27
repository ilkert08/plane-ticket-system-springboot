package com.internship.firstbackend.Controller;

import com.internship.firstbackend.dbconnector.MongoConnector;
import com.internship.firstbackend.model.datamodels.Flight;
import com.internship.firstbackend.model.datamodels.Passenger;
import com.internship.firstbackend.model.requestmodels.PassengerFlightsRequest;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

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


    @GetMapping("/passengersinflight")
    public ArrayList<Passenger> getPassengerListOfFlight(@RequestParam(value = "flightid", defaultValue = "id1") String flightId){
        ArrayList<Passenger> passengerListOfFlight = mongoConnection.getPassengerListOfFlight(flightId);
        return passengerListOfFlight;
    }

    @GetMapping("/flights-from")
    public ArrayList<Flight> getDepartureFlights(@RequestParam(value = "departure", defaultValue = "id1") String departureId){
        ArrayList<Flight> flightsList = mongoConnection.flightsFrom(departureId);
        return flightsList;
    }


    @GetMapping("/flights-to")
    public ArrayList<Flight> getArrivalFlights(@RequestParam(value = "arrival", defaultValue = "id1") String arrivalId){
        ArrayList<Flight> flightsList = mongoConnection.flightsTo(arrivalId);
        return flightsList;
    }

    @GetMapping("/flights-between-airports")
    public ArrayList<Flight> getArrivalFlights(@RequestParam(value = "departure", defaultValue = "id1") String departureId,
                                               @RequestParam(value = "arrival", defaultValue = "id1") String arrivalId){
        ArrayList<Flight> flightsList = mongoConnection.flightsBetweenAirports(departureId, arrivalId);
        return flightsList;
    }

    @GetMapping("/flights-between-dates")
    public ArrayList<Flight> getFlightsBetweenDates(@RequestParam(value = "date1", defaultValue = "id1") String date1,
                                               @RequestParam(value = "date2", defaultValue = "id1") String date2){
        ArrayList<Flight> flightsList = mongoConnection.flightsBetweenDates(date1, date2);
        return flightsList;
    }


    @GetMapping("/cancel-flight")
    public String cancelFlight(@RequestParam(value = "flightid", defaultValue = "id1") String flightId){
        mongoConnection.cancelFlight(flightId);
        return "Uçuş iptal edildi.";
    }



}
