package com.capgemini.airport.controller.api;

import com.capgemini.airport.data.model.Airplane;
import com.capgemini.airport.data.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("airplane_api")
@RequestMapping("/api/airplane")
public class AirplaneController {
    @Autowired
    private AirplaneService airplaneService;

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
        return airplaneService.create(airplane);
    }

    @PutMapping("/")
    public Airplane update(@RequestBody Airplane airplane) {
        return airplaneService.update(airplane);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        return "{'success': true}";
    }
}
