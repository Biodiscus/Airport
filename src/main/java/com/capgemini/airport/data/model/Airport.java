package com.capgemini.airport.data.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // For now
    @OneToMany
    private List<Airplane> airplaneList;

    public long getId() {
        return id;
    }

    public List<Airplane> getAirplaneList() {
        return airplaneList;
    }
}
