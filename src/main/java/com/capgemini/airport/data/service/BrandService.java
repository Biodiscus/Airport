package com.capgemini.airport.data.service;

import com.capgemini.airport.data.model.Brand;
import com.capgemini.airport.data.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BrandService {

    @Autowired
    private BrandRepository repository;

    public Brand create(Brand brand) {
        return repository.save(brand);
    }

    public Iterable<Brand> readAll() {
        return repository.findAll();
    }

    public Brand read(long id) {
        Optional<Brand> optional = repository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        }

        return null;
    }

    public Brand update(Brand brand) {
        Brand old = read(brand.getId());

        // TODO: Update the values

        return repository.save(old);
    }

    public void delete(long id) {
        System.out.println("Deleting brand with id: "+ id);
        repository.deleteById(id);
    }

    public void delete(Brand brand) {
        repository.delete(brand);
    }

}
