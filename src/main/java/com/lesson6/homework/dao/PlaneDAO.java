package com.lesson6.homework.dao;

import com.lesson6.homework.models.Plane;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class PlaneDAO {
    private static final String oldPlanes = "SELECT * FROM PLANES WHERE TO_CHAR(DATE_PRODUCED, 'YYYY') < (TO_CHAR(SYSDATE, 'YYYY') - 20);";
    private static final String regularPlanes = "SELECT * FROM PLANES WHERE PLANES.ID IN (" +
            "SELECT PLANE_ID FROM (" +
            "SELECT COUNT(ID) AS RES,PLANE_ID FROM FLIGHTS WHERE TO_CHAR(FLIGHTS.DATE_FLIGHT, 'YYYY') = ? GROUP BY PLANE_ID)" +
            "WHERE RES > 300);";

    @PersistenceContext
    private EntityManager entityManager;

    public Plane get(Long id){
        return entityManager.find(Plane.class,id);
    }

    public Plane save(Plane plane) {
        entityManager.persist(plane);
        return plane;
    }

    public Plane delete(Long id) {
        Plane plane = entityManager.find(Plane.class, id);
        entityManager.detach(plane);
        return plane;
    }

    public Plane update(Plane plane) {
        entityManager.merge(plane);
        return plane;
    }

    public List<Plane> oldPlanes(){
        return entityManager.createNativeQuery(oldPlanes, Plane.class).getResultList();
    }

    public List<Plane> regularPlanes(int year){
        return entityManager.createNativeQuery(regularPlanes,Plane.class).setParameter(1,year).getResultList();
    }
}
