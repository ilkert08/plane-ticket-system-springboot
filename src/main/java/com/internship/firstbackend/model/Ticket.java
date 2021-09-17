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

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", tc='" + tc + '\'' +
                ", flightId='" + flightId + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
