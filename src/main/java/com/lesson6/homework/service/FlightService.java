package com.lesson6.homework.service;

import com.lesson6.homework.dao.FlightDAO;
import com.lesson6.homework.models.Filter;
import com.lesson6.homework.models.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
    private FlightDAO flightDAO;

    @Autowired
    public FlightService(FlightDAO flightDAO) {
        this.flightDAO = flightDAO;
    }

    public Flight get(Long id){
        return flightDAO.get(id);
    }

    public Flight save(Flight flight) {
        return flightDAO.save(flight);
    }

    public Flight delete(Long id) {
        return flightDAO.delete(id);
    }

    public Flight update(Flight flight) {
        return flightDAO.update(flight);
    }

    public List<Flight> flightsByDate(Filter filter){
        return flightDAO.flightsByDate(filter);
    }

    public List<String> mostPopularTo(){
        return flightDAO.mostPopularTo();
    }
    public List<String> mostPopularFrom(){
        return flightDAO.mostPopularFrom();
    }
}
