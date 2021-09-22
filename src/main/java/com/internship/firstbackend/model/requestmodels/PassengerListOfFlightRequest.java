package com.internship.firstbackend.model.requestmodels;

public class PassengerListOfFlightRequest {

    private String flightId;
    private String id; //Empty.

    public PassengerListOfFlightRequest(String flightId, String id) {
        this.flightId = flightId;
        this.id = id;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PassengerListOfFlightRequest{" +
                "flightId='" + flightId + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
