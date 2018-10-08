package com.capgemini.airport.data.repository;

import com.capgemini.airport.data.model.Brand;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends CrudRepository<Brand, Long> {
}
