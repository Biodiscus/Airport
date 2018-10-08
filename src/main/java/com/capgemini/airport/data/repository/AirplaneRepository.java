package com.capgemini.airport.data.repository;

import com.capgemini.airport.data.model.Airplane;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepository extends CrudRepository<Airplane, Long> {
}
