package com.ss.adminservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "airport")
public class AirportEnt {
    @Id
    @Column(name = "iata_id")
    private String iataId;
    @Column(nullable = false)
    private String city;

    public String getIataId() {
        return iataId;
    }

    public AirportEnt(){}

    public AirportEnt(String iataId, String city){
        this.iataId = iataId;
        this.city = city;
    }

    public AirportEnt setIataId(String iata_id) {
        this.iataId = iata_id;
        return this;
    }

    public String getCity() {
        return city;
    }

    public AirportEnt setCity(String city) {
        this.city = city;
        return this;
    }
}
