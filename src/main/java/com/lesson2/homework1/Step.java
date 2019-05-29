package com.lesson2.homework1;

import java.util.List;

public class Step {
    private long id;
    private Service serviceFrom;
    private Service serviceTo;
    private List<String> paramsServiceFrom;
    private List<String> paramsServiceTo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Service getServiceFrom() {
        return serviceFrom;
    }

    public void setServiceFrom(Service serviceFrom) {
        this.serviceFrom = serviceFrom;
    }

    public Service getServiceTo() {
        return serviceTo;
    }

    public void setServiceTo(Service serviceTo) {
        this.serviceTo = serviceTo;
    }

    public List<String> getParamsServiceFrom() {
        return paramsServiceFrom;
    }

    public void setParamsServiceFrom(List<String> paramsServiceFrom) {
        this.paramsServiceFrom = paramsServiceFrom;
    }

    public List<String> getParamsServiceTo() {
        return paramsServiceTo;
    }

    public void setParamsServiceTo(List<String> paramsServiceTo) {
        this.paramsServiceTo = paramsServiceTo;
    }
}
