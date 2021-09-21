package com.internship.firstbackend.dbconnector;

import com.internship.firstbackend.model.datamodels.*;
import com.internship.firstbackend.model.requestmodels.PassengerFlightsRequest;
import com.internship.firstbackend.model.requestmodels.TicketBuyRequest;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;


public class MongoConnector {
    private MongoClient mongoClient;
    private MongoDatabase database;
    //private final ConnectionString mongoUrl = new ConnectionString("mongodb://user1:Password.12345@cluster0-shard-00-00.gxrol.mongodb.net:27017,cluster0-shard-00-01.gxrol.mongodb.net:27017,cluster0-shard-00-02.gxrol.mongodb.net:27017/flightDB?ssl=true&replicaSet=atlas-bkrq6u-shard-0&authSource=admin&retryWrites=true&w=majority");
    private final ConnectionString mongoUrl = new ConnectionString("mongodb+srv://user1:Password.12345@cluster0.gxrol.mongodb.net/flightDB?retryWrites=true&w=majority");


    private static MongoConnector single_instance = null;

    // Method
    // Static method to create instance of Singleton class
    public static MongoConnector Singleton(){
        // To ensure only one instance is created
        if (single_instance == null) {
            single_instance = new MongoConnector();
        }
        return single_instance;
    }


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
        return planeList;
    }

    public Plane getPlaneById(String requestedPlaneId){
        MongoCollection<Plane> collection = database.getCollection("planes", Plane.class);
        Plane mongoPlane = collection.find(Filters.eq("planeId", requestedPlaneId)).first();
        return mongoPlane;
    }

    public void addPlane(Plane newPlane){
        MongoCollection<Plane> collection = database.getCollection("planes", Plane.class);

        String planeId = new ObjectId().toString(); //Generates unique id
        newPlane.setPlaneId(planeId);
        collection.insertOne(newPlane);
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
        return cityList;
    }

    public City getCityById(String requestedCityId){
        MongoCollection<City> collection = database.getCollection("cities", City.class);
        City mongoCity = collection.find(Filters.eq("cityId", requestedCityId)).first();
        return mongoCity;
    }

    public void addCity(City newCity){
        MongoCollection<City> collection = database.getCollection("cities", City.class);

        String cityId = new ObjectId().toString(); //Generates unique id
        newCity.setCityId(cityId);

        collection.insertOne(newCity);
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
        return airportList;
    }

    public Airport getAirportById(String requestedAirportId){
        MongoCollection<Airport> collection = database.getCollection("airports", Airport.class);
        Airport mongoAirport = collection.find(Filters.eq("airportId", requestedAirportId)).first();
        return mongoAirport;
    }

    public void addAirport(Airport newAirport){
        MongoCollection<Airport> collection = database.getCollection("airports", Airport.class);

        String airportId = new ObjectId().toString(); //Generates unique id
        newAirport.setAirportId(airportId);

        collection.insertOne(newAirport);
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
        return flightList;
    }

    public Flight getFlightById(String requestedFlightId){
        MongoCollection<Flight> collection = database.getCollection("flights", Flight.class);
        Flight mongoFlight = collection.find(Filters.eq("flightId", requestedFlightId)).first();
        return mongoFlight;
    }

    public void addFlight(Flight newFlight){
        String flightId = new ObjectId().toString(); //Generates unique id
        newFlight.setFlightId(flightId);

        List<Integer> sittingPlan = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            sittingPlan.add(0);
        }
        newFlight.setSittingPlan(sittingPlan);


        MongoCollection<Flight> collection = database.getCollection("flights", Flight.class);
        collection.insertOne(newFlight);
    }

    public void updateFlight(Flight updatedFlight){
        MongoCollection<Flight> collection = database.getCollection("flights", Flight.class);
        collection.updateOne(Filters.eq("flightId", updatedFlight.getFlightId()), Updates.combine(Updates.set("sittingPlan", updatedFlight.getSittingPlan())));
        //System.out.println(flight);
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
        return passengerList;
    }

    public Passenger getPassengerById(String requestedPassengerId){
        MongoCollection<Passenger> collection = database.getCollection("passengers", Passenger.class);
        Passenger mongoPassenger = collection.find(Filters.eq("tc", requestedPassengerId)).first();
        return mongoPassenger;
    }

    public void addPassenger(Passenger newPassenger){
        MongoCollection<Passenger> collection = database.getCollection("passengers", Passenger.class);

        String passengerId = new ObjectId().toString(); //Generates unique id
        newPassenger.setTc(passengerId);

        collection.insertOne(newPassenger);
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
        return ticketList;
    }

    public Ticket getTicketById(String requestedTicketId){
        MongoCollection<Ticket> collection = database.getCollection("tickets", Ticket.class);
        Ticket mongoTicket = collection.find(Filters.eq("ticketId", requestedTicketId)).first();
        return mongoTicket;
    }

    public void addTicket(Ticket newTicket){
        MongoCollection<Ticket> collection = database.getCollection("tickets", Ticket.class);

        String ticketId = new ObjectId().toString(); //Generates unique id
        newTicket.setTicketId(ticketId);

        collection.insertOne(newTicket);
    }

    public int buyTicket(TicketBuyRequest ticketBuyRequest){


        String tc = ticketBuyRequest.getTc();
        String flightId = ticketBuyRequest.getFlightId();
        int seatNumber = ticketBuyRequest.getSeatNumber();

        MongoCollection<Ticket> collection = database.getCollection("tickets", Ticket.class);
        ObjectId ticketId = new ObjectId(); //Generates unique id
        String ticketIdStr = ticketId.toString();

        Flight flight = getFlightById(flightId);
        List<Integer> sittingPlan = flight.getSittingPlan();
        if(sittingPlan.get(seatNumber) == 0){
            sittingPlan.set(seatNumber, 1);
            flight.setSittingPlan(sittingPlan);
        }else{
            return 400; //Bilet alınmış.
        }
        updateFlight(flight);
        Ticket newTicket = new Ticket(ticketIdStr, tc, flightId, seatNumber);
        collection.insertOne(newTicket);
        return 200; //Bilet başarıylaa satın alındı.
    }


    public ArrayList<Ticket> getTicketsOfPassenger(PassengerFlightsRequest passengerFlightsRequest){
        String tc = passengerFlightsRequest.getTc();
        MongoCollection<Ticket> collection = database.getCollection("tickets", Ticket.class);
        ArrayList<Ticket> ticketList = collection.find(Filters.eq("tc", tc)).into(new ArrayList<Ticket>());
        return ticketList;
    }













    /*
    public void //closeConnection(){
        mongoClient.close();
    }*/

    private void printResults(List<Document> documents){

    }





}
