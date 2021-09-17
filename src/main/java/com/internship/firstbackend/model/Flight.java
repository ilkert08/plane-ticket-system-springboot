package com.internship.firstbackend.model;

import java.util.Calendar;
import java.util.Date;

public class Flight {
    private String flightId;
    private String departure;
    private String arrival;
    private float flightTime;
    private String planeId;
    private Calendar flightDate;
    private int[] sittingPlan;

    public Flight(String flightId, String departure, String arrival, Float flightTime, String planeId, Calendar flightDate, int[] sittingPlan ) {
        this.flightId = flightId;
        this.departure = departure;
        this.arrival = arrival;
        this.flightTime = flightTime;
        this.planeId = planeId;
        this.flightDate = flightDate;
        this.sittingPlan = sittingPlan;
    }


    public Flight(){

    }

    public String getFlightId() { return flightId; }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }

    public Float getFlightTime() {
        return flightTime;
    }

    public String getPlaneId() {
        return planeId;
    }

    public Calendar getFlightDate() {
        return flightDate;
    }

    public int[] getSittingPlan() { return sittingPlan; }
}
