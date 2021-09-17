package com.internship.firstbackend.Controller;

import com.internship.firstbackend.model.Passenger;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;

@RestController
public class PassengerController {

    private ArrayList<Passenger> passengerList;

    public PassengerController(){
        passengerList = new ArrayList<Passenger>();
        Passenger passenger1 = new Passenger("tc1", "Ali", "Eken", new Date());
        Passenger passenger2 = new Passenger("tc2", "Eren", "Edinç", new Date());
        Passenger passenger3 = new Passenger("tc3", "Samet", "Demirci", new Date());

        passengerList.add(passenger1);
        passengerList.add(passenger2);
        passengerList.add(passenger3);

    }


    @GetMapping("/passengers")
    public ArrayList<Passenger> getAllPassengers(){
        return passengerList;
    }

    @GetMapping("/passenger")
    public Passenger getPassengerById(@RequestParam(value = "id", defaultValue = "tc1") String requestedPassengerId){
        for (int i = 0; i < passengerList.size(); i++) {
            Passenger currentPassenger = passengerList.get(i);
            if(currentPassenger.getTc().equals(requestedPassengerId)){
                return currentPassenger;
            }
        }
        return null;
    }

    @PostMapping("/newpassenger")
    public Passenger addPlane(@RequestBody Passenger newPassenger){
        passengerList.add(newPassenger);
        return passengerList.get(passengerList.size() - 1);
    }
}
