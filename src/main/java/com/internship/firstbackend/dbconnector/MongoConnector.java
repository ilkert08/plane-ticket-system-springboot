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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

        //String cityId = new ObjectId().toString(); //Generates unique id
        //newCity.setCityId(cityId);

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
        MongoCollection<Flight> collection = database.getCollection("flights", Flight.class);


        String flightId = new ObjectId().toString(); //Generates unique id
        newFlight.setFlightId(flightId);

        List<Integer> sittingPlan = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            sittingPlan.add(0);
        }
        newFlight.setSittingPlan(sittingPlan);

        Airport departureAirport = getAirportById(newFlight.getDeparture());
        Airport arrivalAirport = getAirportById(newFlight.getArrival());
        Plane plane = getPlaneById(newFlight.getPlaneId());

        float planeSpeed = plane.getPlaneSpeed();
        List<Double> departureCoordinates = departureAirport.getCoordinate();
        List<Double> arrivalCoordinates = arrivalAirport.getCoordinate();

        double departureAirportLatitude = departureCoordinates.get(0);
        double departureAirportLongitude = departureCoordinates.get(1);

        double arrivalAirportLatitude = arrivalCoordinates.get(0);
        double arrivalAirportLongitude = arrivalCoordinates.get(1);

        int distanceOfAirports = distanceBetweenAirports(departureAirportLatitude, arrivalAirportLatitude,
                departureAirportLongitude, arrivalAirportLongitude); //Meters


        planeSpeed = planeSpeed * 1000; // Kilometers to meters
        float flightTime = distanceOfAirports / planeSpeed;
        newFlight.setFlightTime(flightTime);
        newFlight.setFlightDate(randomFlightDate());

        collection.insertOne(newFlight);
    }

    public void updateFlight(Flight updatedFlight){
        MongoCollection<Flight> collection = database.getCollection("flights", Flight.class);
        collection.updateOne(Filters.eq("flightId", updatedFlight.getFlightId()), Updates.combine(Updates.set("sittingPlan", updatedFlight.getSittingPlan())));
        //System.out.println(flight);
    }

    public ArrayList<Passenger> getPassengerListOfFlight(String flightId) {

        MongoCollection<Ticket> collection = database.getCollection("tickets", Ticket.class);
        ArrayList<Ticket> ticketList = collection.find(Filters.eq("flightId", flightId))
                .into(new ArrayList<Ticket>());
        ArrayList<Passenger> passengerList = new ArrayList<>();
        for(Ticket ticket : ticketList){
            String passengerId = ticket.getTc();
            Passenger newPassenger = getPassengerById(passengerId);
            passengerList.add(newPassenger);
        }
        return passengerList;
    }

    public ArrayList<Flight> flightsFrom(String departureAirportId){ // Flights that will take off from an airport
        ArrayList<Flight> flightList = new ArrayList<>();
        MongoCollection<Flight> collection = database.getCollection("flights", Flight.class);
        List<Flight> flights = collection.find(Filters.eq("departure", departureAirportId)).into(new ArrayList<Flight>());

        System.out.println("Flight that take of from airport:");
        for (Flight mongoFlight : flights) {
            flightList.add(mongoFlight);
            System.out.println(mongoFlight.toString());
        }
        return flightList;
    }

    public ArrayList<Flight> flightsTo(String arrivalAirportId){ // Flights that will take off from an airport
        ArrayList<Flight> flightList = new ArrayList<>();
        MongoCollection<Flight> collection = database.getCollection("flights", Flight.class);
        List<Flight> flights = collection.find(Filters.eq("arrival", arrivalAirportId)).into(new ArrayList<Flight>());

        System.out.println("Flight that will land to airport:");
        for (Flight mongoFlight : flights) {
            flightList.add(mongoFlight);
            System.out.println(mongoFlight.toString());
        }
        return flightList;
    }

    public ArrayList<Flight> flightsBetween(String departureAirportId, String arrivalAirportId){ // Flights that will take off from an airport
        ArrayList<Flight> flightList = new ArrayList<>();
        MongoCollection<Flight> collection = database.getCollection("flights", Flight.class);
        List<Flight> flights = collection
                .find(Filters.and(Filters.eq("arrival", arrivalAirportId), Filters.eq("departure", departureAirportId)))
                .into(new ArrayList<Flight>());


        System.out.println("Flight between airports:");
        for (Flight mongoFlight : flights) {
            flightList.add(mongoFlight);
            System.out.println(mongoFlight.toString());
        }
        return flightList;
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

        //String passengerId = new ObjectId().toString(); //Generates unique id
        //newPassenger.setTc(passengerId);

        newPassenger.setBorndate(randomBornDate());

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

        MongoCollection<Ticket> collection = database.getCollection("tickets", Ticket.class);

        String tc = ticketBuyRequest.getTc();
        String flightId = ticketBuyRequest.getFlightId();
        int seatNumber = ticketBuyRequest.getSeatNumber();

        Flight flight = getFlightById(flightId);
        List<Integer> sittingPlan = flight.getSittingPlan();
        if(sittingPlan.get(seatNumber) == 0){
            sittingPlan.set(seatNumber, 1);
            flight.setSittingPlan(sittingPlan);
        }else{
            return 400; //Bilet alınmış.
        }

        ObjectId ticketId = new ObjectId(); //Generates unique id
        String ticketIdStr = ticketId.toString();
        Ticket newTicket = new Ticket(ticketIdStr, tc, flightId, seatNumber);

        Passenger passenger = getPassengerById(tc);
        int ticketPrice = calculateTicketPrice(passenger, flight);
        if(ticketPrice  == -1){
            return 401; // Eski uçuş.
        }

        newTicket.setTicketPrice(ticketPrice);
        updateFlight(flight);
        collection.insertOne(newTicket);
        return 200; //Bilet başarıylaa satın alındı.
    }

    private int calculateTicketPrice(Passenger passenger, Flight flight) {
        int newPrice = flight.getPrice();
        String flightDate = flight.getFlightDate();
        flightDate = flightDate.split(":")[0]; // 2021-11-29:10-00 format. ":" öncesini almak için [0] indeksi.
        String bornDate = passenger.getBorndate();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();


        LocalDateTime flightDateObj = LocalDate.parse(flightDate, dtf).atStartOfDay();;
        int days = (int) ChronoUnit.DAYS.between(now, flightDateObj);

        int maxRaise = newPrice;
        int raise =  0;

        System.out.println("Old Price:  " + newPrice);

        if(days == 0){
            days = 1;
        } else if(days < 0){
            return -1; // Uçuş günü geçmiş.
        }

        raise = maxRaise / days; // Gün yaklaştıkça fiyat 2 katına kadar atabilir.
        newPrice = newPrice + raise;
        System.out.println("Raised Price:  " + newPrice);

        LocalDateTime bornDateObj = LocalDate.parse(bornDate, dtf).atStartOfDay();;
        long days2 = ChronoUnit.DAYS.between(bornDateObj, now);
        int years = (int)days2 / 360;

        System.out.println(bornDate);
        System.out.println(dtf.format(now));
        System.out.println("Difference:");
        System.out.println("days: " + days2);
        System.out.println("years: " + years);

        if(years <= 10){
            newPrice /= 2; // Age discount.
        }
        System.out.println("New price: " + newPrice);
        return newPrice;
    }


    public ArrayList<Ticket> getTicketsOfPassenger(PassengerFlightsRequest passengerFlightsRequest){
        String tc = passengerFlightsRequest.getTc();
        MongoCollection<Ticket> collection = database.getCollection("tickets", Ticket.class);
        ArrayList<Ticket> ticketList = collection.find(Filters.eq("tc", tc)).into(new ArrayList<Ticket>());
        return ticketList;
    }







    private String randomFlightDate(){
        Random random = new Random();
        int minDay = (int) LocalDate.of(2021, 11, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2022, 1, 1).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);
        LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
        String dateAndTime = randomBirthDate.toString() + ":10-00"; //YYYY-MM-DD:HH:MM
        //System.out.println(dateAndTime);
        return dateAndTime;
    }

    private String randomBornDate(){
        Random random = new Random();
        int minDay = (int) LocalDate.of(1920, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2021, 9, 1).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);
        LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
        String dateAndTime = randomBirthDate.toString(); //YYYY-MM-DD:HH:MM
        //System.out.println(dateAndTime);
        return dateAndTime;
    }





    /**
     * Calculate distance between two points in latitude and longitude taking
     * into account height difference. If you are not interested in height
     * difference pass 0.0. Uses Haversine method as its base.
     *
     * lat1, lon1 Start point lat2, lon2 End point el1 Start altitude in meters
     * el2 End altitude in meters
     * returns Distance in Meters
     */
    public int distanceBetweenAirports(double lat1, double lat2, double lon1, double lon2) {

        double el1 = 0; //Rakım 0 gibi davranıyoruz.
        double el2 = 0; //Rakım 0 gibi davranıyoruz.
        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        double height = el1 - el2;

        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        return (int) Math.sqrt(distance);
    }








    /*
    public void //closeConnection(){
        mongoClient.close();
    }*/

    private void printResults(List<Document> documents){

    }

}
