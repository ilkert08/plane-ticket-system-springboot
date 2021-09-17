package com.internship.firstbackend.dbconnector;

import com.internship.firstbackend.model.*;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import java.util.ArrayList;
import java.util.List;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;


public class MongoConnector {
    private MongoClient mongoClient;
    private MongoDatabase database;
    private final ConnectionString mongoUrl = new ConnectionString("mongodb://user1:Password.12345@cluster0-shard-00-00.gxrol.mongodb.net:27017,cluster0-shard-00-01.gxrol.mongodb.net:27017,cluster0-shard-00-02.gxrol.mongodb.net:27017/flightDB?ssl=true&replicaSet=atlas-bkrq6u-shard-0&authSource=admin&retryWrites=true&w=majority");

    public MongoConnector(){
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());;
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                pojoCodecRegistry);

        MongoClientSettings clientSettings = MongoClientSettings.builder()
                .applyConnectionString(mongoUrl)
                .codecRegistry(codecRegistry)
                .build();

        mongoClient = MongoClients.create(clientSettings);
        database = mongoClient.getDatabase("flightDB");

    }

    public ArrayList<Plane> getPlanes(){
        ArrayList<Plane> planeList = new ArrayList<>();
        MongoCollection<Plane> collection = database.getCollection("planes", Plane.class);
        List<Plane> planes = collection.find().into(new ArrayList<>());
        System.out.println("Plane list with an ArrayList:");
        for (Plane mongoPlane : planes) {
            planeList.add(mongoPlane);
            System.out.println(mongoPlane.toString());
        }
        closeConnection();
        return planeList;
    }

    public Plane getPlaneById(String requestedPlaneId){
        MongoCollection<Plane> collection = database.getCollection("planes", Plane.class);
        List<Plane> planes = collection.find().into(new ArrayList<Plane>());
        System.out.println("Requested plane:");
        for (Plane mongoPlane : planes) {
            if(mongoPlane.getPlaneId().equals(requestedPlaneId)){
                System.out.println(mongoPlane);
                closeConnection();
                return mongoPlane;
            }
        }
        closeConnection();
        return null;
    }

    public void addPlane(Plane newPlane){
        MongoCollection<Plane> collection = database.getCollection("planes", Plane.class);
        collection.insertOne(newPlane);
        closeConnection();
    }



    public ArrayList<City> getCities(){
        ArrayList<City> cityList = new ArrayList<>();
        MongoCollection<City> collection = database.getCollection("cities", City.class);
        List<City> cities = collection.find().into(new ArrayList<>());
        System.out.println("City list with an ArrayList:");
        for (City mongoCity : cities) {
            cityList.add(mongoCity);
            System.out.println(mongoCity.toString());
        }
        closeConnection();
        return cityList;
    }

    public City getCityById(String requestedCityId){
        MongoCollection<City> collection = database.getCollection("cities", City.class);
        List<City> cities = collection.find().into(new ArrayList<City>());
        System.out.println("Requested City:");
        for (City mongoCity : cities) {
            if(mongoCity.getCityId().equals(requestedCityId)){
                System.out.println(mongoCity);
                closeConnection();
                return mongoCity;
            }
        }
        closeConnection();
        return null;
    }

    public void addCity(City newCity){
        MongoCollection<City> collection = database.getCollection("cities", City.class);
        collection.insertOne(newCity);
        closeConnection();
    }



    public ArrayList<Airport> getAirports(){
        ArrayList<Airport> airportList = new ArrayList<>();
        MongoCollection<Airport> collection = database.getCollection("airports", Airport.class);
        List<Airport> airports = collection.find().into(new ArrayList<>());
        System.out.println("Airport list with an ArrayList:");
        for (Airport mongoAirport : airports) {
            airportList.add(mongoAirport);
            System.out.println(mongoAirport.toString());
        }
        closeConnection();
        return airportList;
    }

    public Airport getAirportById(String requestedAirportId){
        MongoCollection<Airport> collection = database.getCollection("airports", Airport.class);
        List<Airport> airports = collection.find().into(new ArrayList<Airport>());
        System.out.println("Requested airport:");
        for (Airport mongoAirport : airports) {
            if(mongoAirport.getCityId().equals(requestedAirportId)){
                System.out.println(mongoAirport);
                closeConnection();
                return mongoAirport;
            }
        }
        closeConnection();
        return null;
    }

    public void addAirport(Airport newAirport){
        MongoCollection<Airport> collection = database.getCollection("airports", Airport.class);
        collection.insertOne(newAirport);
        closeConnection();
    }



    public ArrayList<Flight> getFlights(){
        ArrayList<Flight> flightList = new ArrayList<>();
        MongoCollection<Flight> collection = database.getCollection("flights", Flight.class);
        List<Flight> flights = collection.find().into(new ArrayList<>());
        System.out.println("Flight list with an ArrayList:");
        for (Flight mongoFlight : flights) {
            flightList.add(mongoFlight);
            System.out.println(mongoFlight.toString());
        }
        closeConnection();
        return flightList;
    }

    public Flight getFlightById(String requestedFlightId){
        MongoCollection<Flight> collection = database.getCollection("flights", Flight.class);
        List<Flight> flights = collection.find().into(new ArrayList<Flight>());
        System.out.println("Requested flight:");
        for (Flight mongoFlight : flights) {
            if(mongoFlight.getFlightId().equals(requestedFlightId)){
                System.out.println(mongoFlight);
                closeConnection();
                return mongoFlight;
            }
        }
        closeConnection();
        return null;
    }

    public void addFlight(Flight newFlight){
        MongoCollection<Flight> collection = database.getCollection("flights", Flight.class);
        collection.insertOne(newFlight);
        closeConnection();
    }

    public ArrayList<Passenger> getPassengers(){
        ArrayList<Passenger> passengerList = new ArrayList<>();
        MongoCollection<Passenger> collection = database.getCollection("passengers", Passenger.class);
        List<Passenger> passengers = collection.find().into(new ArrayList<>());
        System.out.println("Passengers list with an ArrayList:");
        for (Passenger mongoPassenger : passengers) {
            passengerList.add(mongoPassenger);
            System.out.println(mongoPassenger.toString());
        }
        closeConnection();
        return passengerList;
    }

    public Passenger getPassengerById(String requestedPassengerId){
        MongoCollection<Passenger> collection = database.getCollection("passengers", Passenger.class);
        List<Passenger> passengers = collection.find().into(new ArrayList<Passenger>());
        System.out.println("Requested Passenger:");
        for (Passenger mongoPassenger : passengers) {
            if(mongoPassenger.getTc().equals(requestedPassengerId)){
                System.out.println(mongoPassenger);
                closeConnection();
                return mongoPassenger;
            }
        }
        closeConnection();
        return null;
    }

    public void addPassenger(Passenger newPassenger){
        MongoCollection<Passenger> collection = database.getCollection("passengers", Passenger.class);
        collection.insertOne(newPassenger);
        closeConnection();
    }


    public ArrayList<Ticket> getTickets(){
        ArrayList<Ticket> ticketList = new ArrayList<>();
        MongoCollection<Ticket> collection = database.getCollection("tickets", Ticket.class);
        List<Ticket> tickets = collection.find().into(new ArrayList<>());
        System.out.println("Ticket list with an ArrayList:");
        for (Ticket mongoTicket : tickets) {
            ticketList.add(mongoTicket);
            System.out.println(mongoTicket.toString());
        }
        closeConnection();
        return ticketList;
    }

    public Ticket getTicketById(String requestedTicketId){
        MongoCollection<Ticket> collection = database.getCollection("tickets", Ticket.class);
        List<Ticket> tickets = collection.find().into(new ArrayList<Ticket>());
        System.out.println("Requested Ticket:");
        for (Ticket mongoTicket : tickets) {
            if(mongoTicket.getTicketId().equals(requestedTicketId)){
                System.out.println(mongoTicket);
                closeConnection();
                return mongoTicket;
            }
        }
        closeConnection();
        return null;
    }

    public void addTicket(Ticket newTicket){
        MongoCollection<Ticket> collection = database.getCollection("tickets", Ticket.class);
        collection.insertOne(newTicket);
        closeConnection();
    }















    private void connect(){

    }

    public void closeConnection(){
        mongoClient.close();
    }

    private void printResults(List<Document> documents){

    }





}
