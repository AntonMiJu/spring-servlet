package com.lesson2.homework1;

import org.springframework.beans.factory.annotation.Autowired;

public class Controller {
    @Autowired
    private Route route;
    @Autowired
    private Service service;
    @Autowired
    private Step step;

    public void callByBean(){
        route.getId();
        route.getSteps();

        service.getId();
        service.getName();
        service.getParamsToCall();

        step.getId();
        step.getServiceFrom();
        step.getServiceTo();
        step.getParamsServiceFrom();
        step.getParamsServiceTo();
    }
}
