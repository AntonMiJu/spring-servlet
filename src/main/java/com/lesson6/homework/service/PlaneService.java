package com.lesson6.homework.service;

import com.lesson6.homework.dao.PlaneDAO;
import com.lesson6.homework.models.Plane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaneService {
    private PlaneDAO planeDAO;

    @Autowired
    public PlaneService(PlaneDAO planeDAO) {
        this.planeDAO = planeDAO;
    }

    public Plane get(Long id) {
        return planeDAO.get(id);
    }

    public Plane save(Plane plane) {
        return planeDAO.save(plane);
    }

    public Plane delete(Long id) {
        return planeDAO.delete(id);
    }

    public Plane update(Plane plane) {
        return planeDAO.update(plane);
    }

    public List<Plane> oldPlanes() {
        return planeDAO.oldPlanes();
    }

    public List<Plane> regularPlanes(int year) {
        return planeDAO.regularPlanes(year);
    }
}
