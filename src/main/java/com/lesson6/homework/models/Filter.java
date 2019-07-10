package com.lesson6.homework.models;

import java.util.Date;

public class Filter {
     private Date dateDeparture;
     private int dateRange;
     private String cityFrom;
     private String cityTo;
     private String modelPlane;

    public Filter(Date dateDeparture, int dateRange, String cityFrom, String cityTo, String modelPlane) {
        this.dateDeparture = dateDeparture;
        this.dateRange = dateRange;
        this.cityFrom = cityFrom;
        this.cityTo = cityTo;
        this.modelPlane = modelPlane;
    }

    public Date getDateDeparture() {
        return dateDeparture;
    }

    public int getDateRange() {
        return dateRange;
    }

    public String getCityFrom() {
        return cityFrom;
    }

    public String getCityTo() {
        return cityTo;
    }

    public String getModelPlane() {
        return modelPlane;
    }

    public void setDateDeparture(Date dateDeparture) {
        this.dateDeparture = dateDeparture;
    }

    public void setDateRange(int dateRange) {
        this.dateRange = dateRange;
    }

    public void setCityFrom(String cityFrom) {
        this.cityFrom = cityFrom;
    }

    public void setCityTo(String cityTo) {
        this.cityTo = cityTo;
    }

    public void setModelPlane(String modelPlane) {
        this.modelPlane = modelPlane;
    }
}
