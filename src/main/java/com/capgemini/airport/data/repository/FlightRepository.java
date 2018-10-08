package com.capgemini.airport.data.repository;

import com.capgemini.airport.data.model.Flight;
import com.capgemini.airport.data.model.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends CrudRepository<Flight, Long> {
}
