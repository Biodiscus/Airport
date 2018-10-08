package com.capgemini.airport.controller.api;

import com.capgemini.airport.data.model.Flight;
import com.capgemini.airport.data.service.BrandService;
import com.capgemini.airport.data.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("flight_api")
@RequestMapping("/api/flight")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @GetMapping("/")
    public Iterable<Flight> getAll() {
        return flightService.readAll();
    }

    @GetMapping("/{id}")
    public Flight get(Long id) {
        return flightService.read(id);
    }

    @PostMapping("/")
    public Flight create(@RequestBody Flight flight) {
        return flightService.create(flight);
    }

    @PutMapping("/")
    public Flight update(@RequestBody Flight flight) {
        return flightService.update(flight);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        flightService.delete(id);
        return "{'success': true}";
    }
}
