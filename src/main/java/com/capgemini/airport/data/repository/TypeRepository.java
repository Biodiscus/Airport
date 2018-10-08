package com.capgemini.airport.data.repository;

import com.capgemini.airport.data.model.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends CrudRepository<Type, Long> {
}
