package com.internship.firstbackend.Controller;
import com.internship.firstbackend.model.Airport;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
public class AirportController {


    private ArrayList<Airport> airportList;

    public AirportController(){
        airportList = new ArrayList<Airport>();

        String[] arr = {"30", "40"};
        Airport airport1 = new Airport("id1", "Sabiha Gökçen Havalimanı", "34", arr);
        Airport airport2 = new Airport("id2", "Atatürk Havalimanı", "34", arr);
        Airport airport3 = new Airport("id3", "Büyük Istanbul Havalimanı", "34", arr);

        airportList.add(airport1);
        airportList.add(airport2);
        airportList.add(airport3);

    }


    @GetMapping("/airports")
    public ArrayList<Airport> getAllAirports(){
        return airportList;
    }

    @GetMapping("/airport")
    public Airport getPassengerById(@RequestParam(value = "id", defaultValue = "id1") String requestedAirportId){
        for (int i = 0; i < airportList.size(); i++) {
            Airport currentAirport = airportList.get(i);
            if(currentAirport.getAirportId().equals(requestedAirportId)){
                return currentAirport;
            }
        }
        return null;
    }

    @PostMapping("/newairport")
    public Airport addPlane(@RequestBody Airport newAirport){
        airportList.add(newAirport);
        return airportList.get(airportList.size() - 1);
    }

}
