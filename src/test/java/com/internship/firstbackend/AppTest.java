package com.internship.firstbackend;

import com.internship.firstbackend.dbconnector.MongoConnector;
import com.internship.firstbackend.model.datamodels.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class AppTest {
    private MockData data;
    private MongoConnector con;

    public AppTest(){
        con = MongoConnector.Singleton();
        data = new MockData();
    }

    @Test
    void addPassenger() {
        ArrayList<Passenger> passengers = data.passengers; //İlk 3 true, kalanı false.

        for (int i = 0; i < passengers.size(); i++) {
            Passenger passenger = passengers.get(i);
            boolean result;
            result = con.addPassenger(passenger);
            if(i<3){
                assertFalse((result), i + ". girdi testi gecemedi.");
            }else{
                assertTrue((result), i + ". girdi testi gecemedi.");
            }
        }
    }


    @Test
    void addFlight() {
        ArrayList<Flight> flights = data.flights; //İlk 3 true, kalanı false.

        for (int i = 0; i < flights.size(); i++) {
            Flight flight = flights.get(i);
            boolean result;
            result = con.addFlight(flight);
            if(i<1){
                assertTrue((result), i + ". girdi testi gecemedi.");
            }else{
                assertFalse((result), i + ". girdi testi gecemedi.");
            }
            System.out.println((i+1) + ". test gecildi.");
        }
    }








    private class MockData{
        ArrayList<Flight> flights ;
        ArrayList<Passenger> passengers ;
        ArrayList<Ticket> tickets;
        ArrayList<Plane> planes;
        ArrayList<Airport> airports;
        ArrayList<City> cities;


        public MockData(){

            flights = new ArrayList<>();
            passengers = new ArrayList<>();
            tickets = new ArrayList<>();
            planes = new ArrayList<>();
            airports = new ArrayList<>();
            cities = new ArrayList<>();

            passengers.add(new Passenger("-5", "Ali", "Veli", "20-03-1990"));
            passengers.add(new Passenger("xxxx", "Ali", "Veli", "20-03-1990"));
            passengers.add(new Passenger("30x6", "Ali", "Veli", "20-03-1990"));
            passengers.add(new Passenger("0001", "Ali", "Veli", "20-03-1990"));
            passengers.add(new Passenger("0002", "Ali", "Veli", "20-03-1990"));
            passengers.add(new Passenger("0003", "Ali", "Veli", "20-03-1990"));


            flights.add(new Flight(null, "614aeb0f7bf62f599029603e", "614aeaa87bf62f599029603c",  0F, "61487df748fe0a34b40cd4a6",
                    null, null, 700));

            flights.add(new Flight(null, "xxxxxx", "614aeaa87bf62f599029603c", 0F, "61487df748fe0a34b40cd4a6",
                    null, null, 700));

            flights.add(new Flight(null, "614aeb0f7bf62f599029603e", "xxxxxxx", 0F, "61487df748fe0a34b40cd4a6",
                    null, null, 700));

            flights.add(new Flight(null, "614aeb0f7bf62f599029603e", "614aeaa87bf62f599029603c", 0F, "xxxxx",
                    null, null, 700));

            flights.add(new Flight(null, "614aeb0f7bf62f599029603e", "614aeaa87bf62f599029603c", 0F, "61487df748fe0a34b40cd4a6",
                    null, null, -5));

            flights.add(new Flight(null, "xxxxx", "xxxxxx", 0F, "61487df748fe0a34b40cd4a6",
                    null, null, 700));




        }
    }



}