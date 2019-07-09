package com.lesson6.homework.models;

import java.util.ArrayList;
import java.util.Date;

public class Flight {
    private Long id;
    private Plane plane;
    private ArrayList<Passenger> passenger;
    private Date dateFlight;
    private String cityFrom;
    private String cityTo;

    public Long getId() {
        return id;
    }

    public Plane getPlane() {
        return plane;
    }

    public ArrayList<Passenger> getPassenger() {
        return passenger;
    }

    public Date getDateFlight() {
        return dateFlight;
    }

    public String getCityFrom() {
        return cityFrom;
    }

    public String getCityTo() {
        return cityTo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public void setPassenger(ArrayList<Passenger> passenger) {
        this.passenger = passenger;
    }

    public void setDateFlight(Date dateFlight) {
        this.dateFlight = dateFlight;
    }

    public void setCityFrom(String cityFrom) {
        this.cityFrom = cityFrom;
    }

    public void setCityTo(String cityTo) {
        this.cityTo = cityTo;
    }
}
