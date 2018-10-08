package com.capgemini.airport.data.service;

import com.capgemini.airport.data.model.Airplane;
import com.capgemini.airport.data.repository.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AirplaneService {

    @Autowired
    private AirplaneRepository repository;

    public Airplane create(Airplane airplane) {
        return repository.save(airplane);
    }

    public Iterable<Airplane> readAll() {
        return repository.findAll();
    }

    public Airplane read(long id) {
        Optional<Airplane> optional = repository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        }

        return null;
    }

    public Airplane update(Airplane airplane) {
        Airplane old = read(airplane.getId());

        // TODO: Update the values

        return repository.save(old);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

    public void delete(Airplane airplane) {
        repository.delete(airplane);
    }

}
