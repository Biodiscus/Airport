package com.capgemini.airport.data.service;

import com.capgemini.airport.data.model.Airport;
import com.capgemini.airport.data.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AirportService {

    @Autowired
    private AirportRepository repository;

    public Airport create(Airport airport) {
        return repository.save(airport);
    }

    public Iterable<Airport> readAll() {
        return repository.findAll();
    }

    public Airport read(long id) {
        Optional<Airport> optional = repository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        }

        return null;
    }

    public Airport update(Airport airport) {
        Airport old = read(airport.getId());

        // TODO: Update the values

        return repository.save(old);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

    public void delete(Airport airport) {
        repository.delete(airport);
    }
}
