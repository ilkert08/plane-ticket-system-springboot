package com.internship.firstbackend.model.requestmodels;

public class PassengerFlightsRequest {

    private String tc;
    private String flightId;

    public PassengerFlightsRequest(String tc, String flightId) {
        this.tc = tc;
        this.flightId = flightId;
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




    @Override
    public String toString() {
        return "TicketBuyRequest{" +
                "tc='" + tc + '\'' +
                ", flightId='" + flightId + '\'' +
                '}';
    }




}
