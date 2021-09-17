package com.internship.firstbackend.Controller;

import com.internship.firstbackend.model.Ticket;
import com.internship.firstbackend.model.Ticket;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TicketController {
    private ArrayList<Ticket> ticketList;


    public TicketController(){
        ticketList = new ArrayList<Ticket>();

        Ticket ticket1 = new Ticket("id1", "tc1", "flight1", "300");
        Ticket ticket2 = new Ticket("id2", "tc2", "flight1", "300");
        Ticket ticket3 = new Ticket("id3", "tc3", "flight1", "300");

        ticketList.add(ticket1);
        ticketList.add(ticket2);
        ticketList.add(ticket3);

    }


    @GetMapping("/tickets")
    public ArrayList<Ticket> getAllAirports(){
        return ticketList;
    }

    @GetMapping("/ticket")
    public Ticket getTicketById(@RequestParam(value = "id", defaultValue = "id1") String requestedTicketId){
        for (int i = 0; i < ticketList.size(); i++) {
            Ticket currentTicket = ticketList.get(i);
            if(currentTicket.getTicketId().equals(requestedTicketId)){
                return currentTicket;
            }
        }
        return null;
    }

    @PostMapping("/newTicket")
    public Ticket addPlane(@RequestBody Ticket newTicket){
        ticketList.add(newTicket);
        return ticketList.get(ticketList.size() - 1);
    }


}
