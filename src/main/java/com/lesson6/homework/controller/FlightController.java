package com.lesson6.homework.controller;

import com.lesson6.homework.models.Filter;
import com.lesson6.homework.models.Flight;
import com.lesson6.homework.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class FlightController {
    private FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    public Flight get(Long id) {
        return flightService.get(id);
    }

    public Flight save(Flight flight) {
        return flightService.save(flight);
    }

    public Flight delete(Long id) {
        return flightService.delete(id);
    }

    public Flight update(Flight flight) {
        return flightService.update(flight);
    }

    public List<Flight> flightsByDate(Filter filter) {
        return flightService.flightsByDate(filter);
    }

    public List<String> mostPopularTo() {
        return flightService.mostPopularTo();
    }

    public List<String> mostPopularFrom() {
        return flightService.mostPopularFrom();
    }
}
