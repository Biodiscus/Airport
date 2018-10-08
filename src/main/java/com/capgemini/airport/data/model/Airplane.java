package com.capgemini.airport.data.model;


import javax.persistence.*;

@Entity
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Type type;

    private String fuel;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }


    @Transient
    public String getName() {
        if (this.type != null && this.type.getBrand() != null) {
            return this.type.getBrand().getName() + " " + this.type.getName();
        } else {
            return "No type specified";
        }
    }
}
