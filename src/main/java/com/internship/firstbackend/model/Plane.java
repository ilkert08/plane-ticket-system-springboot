package com.internship.firstbackend.model;

public class Plane {
    private String planeId;
    private int capacity;
    private String planeBrand;
    private String planeModel;
    private float planeSpeed;

    public Plane(String planeId, int capacity, String planeBrand, String planeModel, float planeSpeed) {
        this.planeId = planeId;
        this.capacity = capacity;
        this.planeBrand = planeBrand;
        this.planeModel = planeModel;
        this.planeSpeed = planeSpeed;
    }

    public Plane(int capacity, String planeBrand, String planeModel, float planeSpeed) {
        this.capacity = capacity;
        this.planeBrand = planeBrand;
        this.planeModel = planeModel;
        this.planeSpeed = planeSpeed;
    }

    public Plane(){

    }

    public String getPlaneId() {
        return planeId;
    }

    public int getCapacity() {
        return capacity;
    }


    public String getPlaneBrand() {
        return planeBrand;
    }


    public String getPlaneModel() {
        return planeModel;
    }


    public float getPlaneSpeed() {
        return planeSpeed;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "planeId='" + planeId + '\'' +
                ", capacity=" + capacity +
                ", planeBrand='" + planeBrand + '\'' +
                ", planeModel='" + planeModel + '\'' +
                ", planeSpeed=" + planeSpeed +
                '}';
    }
}
