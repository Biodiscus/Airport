package com.capgemini.airport.data.service;

import com.capgemini.airport.data.model.Type;
import com.capgemini.airport.data.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TypeService {

    @Autowired
    private TypeRepository repository;

    public Type create(Type type) {
        return repository.save(type);
    }

    public Iterable<Type> readAll() {
        return repository.findAll();
    }

    public Type read(long id) {
        Optional<Type> optional = repository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        }

        return null;
    }

    public Type update(Type type) {
        Type old = read(type.getId());

        if(!old.getName().equals(type.getName())) {
            old.setName(type.getName());
        }

        if(!old.getBrand().equals(type.getBrand())) {
            old.setBrand(type.getBrand());
        }

        return repository.save(old);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

    public void delete(Type type) {
        repository.delete(type);
    }

}
