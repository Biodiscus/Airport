package com.capgemini.airport.data.service;

import com.capgemini.airport.data.model.Flight;
import com.capgemini.airport.data.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    private FlightRepository repository;

    public Flight create(Flight flight) {
        return repository.save(flight);
    }

    public Iterable<Flight> readAll() {
        return repository.findAll();
    }

    public Flight read(long id) {
        Optional<Flight> optional = repository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        }

        return null;
    }

    public Flight update(Flight flight) {
        Flight old = read(flight.getId());

        if (!old.getWhen().equals(flight.getWhen())) {
            old.setWhen(flight.getWhen());
        }

        if (!old.getStart().equals(flight.getStart())) {
            old.setStart(flight.getStart());
        }

        if (!old.getEnd().equals(flight.getEnd())) {
            old.setEnd(flight.getEnd());
        }

        return repository.save(old);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

    public void delete(Flight flight) {
        repository.delete(flight);
    }

}
