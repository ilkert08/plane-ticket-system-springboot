package com.internship.firstbackend.model.datamodels;

public class Ticket {

    private String ticketId;
    private String tc;
    private String flightId;
    private int seatNumber;

    public Ticket(String ticketId, String tc, String flightId, int seatNumber) {
        this.ticketId = ticketId;
        this.tc = tc;
        this.flightId = flightId;
        this.seatNumber = seatNumber;
    }

    public Ticket(){

    }


    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
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

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }


    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", tc='" + tc + '\'' +
                ", flightId='" + flightId + '\'' +
                ", seatNumber='" + seatNumber + '\'' +
                '}';
    }

}
