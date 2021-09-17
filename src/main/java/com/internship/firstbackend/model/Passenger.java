package com.internship.firstbackend.model;

import java.util.Date;

public class Passenger {
    private String tc;
    private String name;
    private String surname;
    private String borndate;

    public Passenger(){

    }

    public Passenger(String tc, String name, String surname, String borndate) {
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

    public String getBorndate() {
        return borndate;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBorndate(String borndate) {
        this.borndate = borndate;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "tc='" + tc + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", borndate=" + borndate +
                '}';
    }
}
