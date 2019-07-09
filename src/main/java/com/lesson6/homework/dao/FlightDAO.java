package com.lesson6.homework.dao;

import com.lesson6.homework.models.Flight;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class FlightDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public Flight get(Long id){
        return entityManager.find(Flight.class,id);
    }

    public Flight save(Flight flight) {
        entityManager.persist(flight);
        return flight;
    }

    public Flight delete(Long id) {
        Flight flight = entityManager.find(Flight.class, id);
        entityManager.detach(flight);
        return flight;
    }

    public Flight update(Flight flight) {
        entityManager.merge(flight);
        return flight;
    }
}
