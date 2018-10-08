package com.capgemini.airport.controller.api;

import com.capgemini.airport.data.model.Airplane;
import com.capgemini.airport.data.service.AirplaneService;
import com.capgemini.airport.data.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("airplane_api")
@RequestMapping("/api/airplane")
public class AirplaneController {
    @Autowired
    private AirplaneService airplaneService;

    @Autowired
    private TypeService typeService;

    @GetMapping("/")
    public Iterable<Airplane> getAll() {
        return airplaneService.readAll();
    }

    @GetMapping("/{id}")
    public Airplane get(Long id) {
        return airplaneService.read(id);
    }

    @PostMapping("/")
    public Airplane create(@RequestBody Airplane airplane) {
        airplane = airplaneService.create(airplane);

        if (airplane.getType() != null) {
            long id = airplane.getType().getId();
            airplane.setType(typeService.read(id));
        }

        return airplane;
    }

    @PutMapping("/")
    public Airplane update(@RequestBody Airplane airplane) {
        airplane = airplaneService.update(airplane);

        if (airplane.getType() != null) {
            long id = airplane.getType().getId();
            airplane.setType(typeService.read(id));
        }

        return airplane;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        airplaneService.delete(id);
        return "{'success': true}";
    }
}
