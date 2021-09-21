package com.internship.firstbackend.Controller;

import com.internship.firstbackend.dbconnector.MongoConnector;
import com.internship.firstbackend.model.datamodels.Passenger;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
public class PassengerController {

    private ArrayList<Passenger> passengerList;
    private MongoConnector mongoConnection;

    public PassengerController(){
        passengerList = new ArrayList<Passenger>();
        mongoConnection = MongoConnector.Singleton();



    }


    @GetMapping("/passengers")
    public ArrayList<Passenger> getAllPassengers(){
        passengerList = mongoConnection.getPassengers();
        return passengerList;
    }

    @GetMapping("/passenger")
    public Passenger getPassengerById(@RequestParam(value = "id", defaultValue = "tc1") String requestedPassengerId){
        Passenger requestedPassenger = mongoConnection.getPassengerById(requestedPassengerId);

        if(requestedPassenger != null){
            return requestedPassenger;
        }
        return null;
    }

    @PostMapping("/newpassenger")
    public Passenger addPassenger(@RequestBody Passenger newPassenger){
        mongoConnection.addPassenger(newPassenger);
        return newPassenger;
    }
}
