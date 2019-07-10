package com.lesson6.homework.dao;

import com.lesson6.homework.models.Filter;
import com.lesson6.homework.models.Flight;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class FlightDAO {
    private static final String flightsByDate = "SELECT FLIGHTS.* FROM FLIGHTS, PLANES WHERE PLANES.ID = FLIGHTS.PLANE_ID AND PLANES.MODEL = ? AND CITY_FROM = ? AND CITY_TO = ? AND DATE_FLIGHT BETWEEN ? AND ?";
    private static final String mostPopularTo = "SELECT * FROM (SELECT COUNT(ID), CITY_TO FROM FLIGHTS " +
            "GROUP BY CITY_TO ORDER BY COUNT(ID) DESC)";
    private static final String mostPopularFrom = "SELECT * FROM (SELECT COUNT(ID), CITY_FROM FROM FLIGHTS " +
            "GROUP BY CITY_FROM ORDER BY COUNT(ID) DESC)";

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

    public List<Flight> flightsByDate(Filter filter){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(filter.getDateDeparture());
        calendar.add(Calendar.DATE,filter.getDateRange());
        Date dateStart = calendar.getTime();
        calendar.setTime(filter.getDateDeparture());
        calendar.add(Calendar.DATE,-filter.getDateRange());
        Date dateEnd = calendar.getTime();
        return entityManager.createNativeQuery(flightsByDate,Flight.class)
                .setParameter(1,filter.getModelPlane())
                .setParameter(2,filter.getCityFrom())
                .setParameter(3,filter.getCityTo())
                .setParameter(4,dateStart)
                .setParameter(5,dateEnd).getResultList();
    }

    public List<String> mostPopularTo(){
        return entityManager.createNativeQuery(mostPopularTo,String.class).getResultList();
    }

    public List<String> mostPopularFrom(){
        return entityManager.createNativeQuery(mostPopularFrom,String.class).getResultList();
    }
}
