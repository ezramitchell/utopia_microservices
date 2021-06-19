package com.ss.adminservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "airport")
public class AirportEnt {
    @Id
    private String iata_id;
    @Column(nullable = false)
    private String city;

    public String getIata_id() {
        return iata_id;
    }

    public AirportEnt(){}

    public AirportEnt(String iata_id, String city){
        this.iata_id = iata_id;
        this.city = city;
    }

    public AirportEnt setIata_id(String iata_id) {
        this.iata_id = iata_id;
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
