package com.lesson6.homework.controller;

import com.lesson6.homework.models.Passenger;
import com.lesson6.homework.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PassengerController {
    private PassengerService passengerService;

    @Autowired
    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    public Passenger get(Long id) {
        return passengerService.get(id);
    }

    public Passenger save(Passenger passenger) {
        return passengerService.save(passenger);
    }

    public Passenger delete(Long id) {
        return passengerService.delete(id);
    }

    public Passenger update(Passenger passenger) {
        return passengerService.update(passenger);
    }

    public List<Passenger> regularPassengers(int year) {
        return passengerService.regularPassengers(year);
    }
}
