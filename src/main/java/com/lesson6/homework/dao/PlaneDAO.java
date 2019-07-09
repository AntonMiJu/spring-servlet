package com.lesson6.homework.dao;

import com.lesson6.homework.models.Plane;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
@Transactional
public class PlaneDAO {
    private static final String oldPlanes = "SELECT * FROM PLANES WHERE DATEDIFF(YEAR, DATE_PRODUCED, GETDATE()) > 20";

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

    public ArrayList<Plane> oldPlanes(){
        return (ArrayList<Plane>) entityManager.createNativeQuery(oldPlanes, Plane.class).getResultList();
    }
}
