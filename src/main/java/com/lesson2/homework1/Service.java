package com.lesson2.homework1;

import java.util.List;

public class Service {
    private long id;
    private String name;
    private List<String> paramsToCall;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getParamsToCall() {
        return paramsToCall;
    }

    public void setParamsToCall(List<String> paramsToCall) {
        this.paramsToCall = paramsToCall;
    }
}
