package com.capgemini.airport.controller.api;

import com.capgemini.airport.data.model.Airport;
import com.capgemini.airport.data.service.AirportService;
import com.capgemini.airport.data.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("airport_api")
@RequestMapping("/api/airport")
public class AirportController {
    @Autowired
    private AirportService airportService;

    @GetMapping("/")
    public Iterable<Airport> getAll() {
        return airportService.readAll();
    }

    @GetMapping("/{id}")
    public Airport get(Long id) {
        return airportService.read(id);
    }

    @PostMapping("/")
    public Airport create(@RequestBody Airport airport) {
        airport = airportService.create(airport);
        return airport;
    }

    @PutMapping("/")
    public Airport update(@RequestBody Airport airport) {
        airport = airportService.update(airport);
        return airport;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        airportService.delete(id);
        return "{'success': true}";
    }
}
