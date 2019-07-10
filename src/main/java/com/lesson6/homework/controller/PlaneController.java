package com.lesson6.homework.controller;

import com.lesson6.homework.models.Plane;
import com.lesson6.homework.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PlaneController {
    private PlaneService planeService;

    @Autowired
    public PlaneController(PlaneService planeService) {
        this.planeService = planeService;
    }

    public Plane get(Long id) {
        return planeService.get(id);
    }

    public Plane save(Plane plane) {
        return planeService.save(plane);
    }

    public Plane delete(Long id) {
        return planeService.delete(id);
    }

    public Plane update(Plane plane) {
        return planeService.update(plane);
    }

    public List<Plane> oldPlanes() {
        return planeService.oldPlanes();
    }

    public List<Plane> regularPlanes(int year) {
        return planeService.regularPlanes(year);
    }
}
