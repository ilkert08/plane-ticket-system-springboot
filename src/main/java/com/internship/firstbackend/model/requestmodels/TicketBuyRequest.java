package com.internship.firstbackend.model.requestmodels;

public class TicketBuyRequest {

    private String tc;
    private String flightId;
    private int seatNumber;

    public TicketBuyRequest(String tc, String flightId, int seatNumber) {
        this.tc = tc;
        this.flightId = flightId;
        this.seatNumber = seatNumber;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }


    @Override
    public String toString() {
        return "TicketBuyRequest{" +
                "tc='" + tc + '\'' +
                ", flightId='" + flightId + '\'' +
                ", seatNumber=" + seatNumber +
                '}';
    }
}
