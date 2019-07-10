package com.lesson6.homework.service;

import com.lesson6.homework.dao.PassengerDAO;
import com.lesson6.homework.models.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {
    private PassengerDAO passengerDAO;

    @Autowired
    public PassengerService(PassengerDAO passengerDAO) {
        this.passengerDAO = passengerDAO;
    }

    public Passenger get(Long id){
        return passengerDAO.get(id);
    }

    public Passenger save(Passenger passenger) {
        return passengerDAO.save(passenger);
    }

    public Passenger delete(Long id) {
        return passengerDAO.delete(id);
    }

    public Passenger update(Passenger passenger) {
        return passengerDAO.update(passenger);
    }

    public List<Passenger> regularPassengers(int year){
        return passengerDAO.regularPassengers(year);
    }
}
