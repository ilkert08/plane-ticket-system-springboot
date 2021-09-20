package com.internship.firstbackend.model;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Flight {
    private String flightId;
    private String departure;
    private String arrival;
    private float flightTime;
    private String planeId;
    private String flightDate; //TODO Calendar veri tipi mongo db kabul etmiyor!!
    private List<Integer> sittingPlan;
    private int price;

    public Flight(String flightId, String departure, String arrival, Float flightTime, String planeId, String flightDate, List<Integer> sittingPlan, int price ) {
        this.flightId = flightId;
        this.departure = departure;
        this.arrival = arrival;
        this.flightTime = flightTime;
        this.planeId = planeId;
        this.flightDate = flightDate;
        this.sittingPlan = sittingPlan;
        this.price = price;
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

    public String getFlightDate() {
        return flightDate;
    }

    public List<Integer> getSittingPlan() { return sittingPlan; }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public void setFlightTime(float flightTime) {
        this.flightTime = flightTime;
    }

    public void setPlaneId(String planeId) {
        this.planeId = planeId;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    public void setSittingPlan(List<Integer> sittingPlan) {
        this.sittingPlan = sittingPlan;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightId='" + flightId + '\'' +
                ", departure='" + departure + '\'' +
                ", arrival='" + arrival + '\'' +
                ", flightTime=" + flightTime +
                ", planeId='" + planeId + '\'' +
                ", flightDate='" + flightDate + '\'' +
                ", sittingPlan=" + sittingPlan +
                ", price=" + price +
                '}';
    }
}
