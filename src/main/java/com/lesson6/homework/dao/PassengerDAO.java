package com.lesson6.homework.dao;

import com.lesson6.homework.models.Passenger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PassengerDAO {
    private static final String regularPassengers = "SELECT * FROM PASSENGERS WHERE PASSENGERS.ID IN (SELECT PASSENGER_ID FROM (" +
            "SELECT COUNT(FLIGHT_ID) AS RES, PASSENGER_ID FROM FLIGHT_DETAILS WHERE FLIGHT_ID IN " +
            "(SELECT ID FROM FLIGHTS WHERE TO_CHAR(DATE_FLIGHT, 'YYYY') = ?) GROUP BY PASSENGER_ID) WHERE RES >25);";

    @PersistenceContext
    private EntityManager entityManager;

    public Passenger get(Long id){
        return entityManager.find(Passenger.class,id);
    }

    public Passenger save(Passenger passenger) {
        entityManager.persist(passenger);
        return passenger;
    }

    public Passenger delete(Long id) {
        Passenger passenger = entityManager.find(Passenger.class, id);
        entityManager.detach(passenger);
        return passenger;
    }

    public Passenger update(Passenger passenger) {
        entityManager.merge(passenger);
        return passenger;
    }

    public List<Passenger> regularPassengers(int year){
        return entityManager.createNativeQuery(regularPassengers,Passenger.class).setParameter(1,year).getResultList();
    }
}
