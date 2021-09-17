package com.internship.firstbackend.model;

import java.util.Date;

public class Passenger {
    private String tc;
    private String name;
    private String surname;
    private Date borndate;

    public Passenger(){

    }

    public Passenger(String tc, String name, String surname, Date borndate) {
        this.tc = tc;
        this.name = name;
        this.surname = surname;
        this.borndate = borndate;
    }

    public String getTc() {
        return tc;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getBorndate() {
        return borndate;
    }
}
