package com.lesson6.homework.dao;

import com.lesson6.homework.models.Passenger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PassengerDAO {
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
}
