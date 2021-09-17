package com.internship.firstbackend.model;

public class Ticket {

    private String ticketId;
    private String tc;
    private String flightId;
    private String price;

    public Ticket(String ticketId, String tc, String flightId, String price) {
        this.ticketId = ticketId;
        this.tc = tc;
        this.flightId = flightId;
        this.price = price;
    }

    public Ticket(){

    }

    public String getTicketId() {
        return ticketId;
    }

    public String getTc() {
        return tc;
    }

    public String getFlightId() {
        return flightId;
    }

    public String getPrice() {
        return price;
    }
}
