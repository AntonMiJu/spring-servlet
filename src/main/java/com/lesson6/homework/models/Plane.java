package com.lesson6.homework.models;

import java.util.Date;

public class Plane {
    private Long id;
    private String model;
    private String code;
    private Date yearProduced;
    private double avgFuelConsumption;

    public Long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getCode() {
        return code;
    }

    public Date getYearProduced() {
        return yearProduced;
    }

    public double getAvgFuelConsumption() {
        return avgFuelConsumption;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setYearProduced(Date yearProduced) {
        this.yearProduced = yearProduced;
    }

    public void setAvgFuelConsumption(double avgFuelConsumption) {
        this.avgFuelConsumption = avgFuelConsumption;
    }
}
