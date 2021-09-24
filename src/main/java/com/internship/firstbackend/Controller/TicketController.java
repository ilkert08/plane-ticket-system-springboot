package com.internship.firstbackend.Controller;

import com.internship.firstbackend.dbconnector.MongoConnector;
import com.internship.firstbackend.model.datamodels.Ticket;
import com.internship.firstbackend.model.requestmodels.PassengerFlightsRequest;
import com.internship.firstbackend.model.requestmodels.TicketBuyRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TicketController {
    private ArrayList<Ticket> ticketList;
    private MongoConnector mongoConnection;


    public TicketController(){
        ticketList = new ArrayList<Ticket>();
        mongoConnection = MongoConnector.Singleton();


        /*
        Ticket ticket1 = new Ticket("id1", "tc1", "flight1", "300");
        Ticket ticket2 = new Ticket("id2", "tc2", "flight1", "300");
        Ticket ticket3 = new Ticket("id3", "tc3", "flight1", "300");

        ticketList.add(ticket1);
        ticketList.add(ticket2);
        ticketList.add(ticket3);

         */

    }



    @GetMapping("/tickettest")
    public String ticketTest(){
        ticketList = mongoConnection.getTickets();
        return mongoConnection.toString();
    }



    @GetMapping("/tickets")
    public ArrayList<Ticket> getAllTickets(){
        ticketList = mongoConnection.getTickets();
        return ticketList;
    }

    @GetMapping("/ticket")
    public Ticket getTicketById(@RequestParam(value = "id", defaultValue = "id1") String requestedTicketId){
        Ticket requestedTicket = mongoConnection.getTicketById(requestedTicketId);

        if(requestedTicket != null){
            return requestedTicket;
        }
        return null;
    }

    @PostMapping("/newticket")
    public Ticket addTicket(@RequestBody Ticket newTicket){
        mongoConnection.addTicket(newTicket);
        return newTicket;
    }

    @PostMapping("/buyticket")
    public String buyNewTicket(@RequestBody TicketBuyRequest ticketBuyRequest){
        int result = mongoConnection.buyTicket(ticketBuyRequest);
        String message = "";

        if(result == 200){
            message = "Bilet başarıyla satın alındı.";
            return message;
        }else if(result == 400){
            message = "Koltuk daha önce satın alınmış.";
            return message;
        }else if(result == 401){
            message = "Uçuş tarihi geçmiş.";
            return message;
        }
        else{
            message = "Başka bir hata.";
            return message;
        }
    }

    @PostMapping("/passengertickets")
    public ArrayList<Ticket> passengerTickets(@RequestBody PassengerFlightsRequest passengerFlightsRequest){
        System.out.println(passengerFlightsRequest);
        ArrayList<Ticket> passengerTicketList;
        passengerTicketList = mongoConnection.getTicketsOfPassenger(passengerFlightsRequest);
        return passengerTicketList;
    }



}
