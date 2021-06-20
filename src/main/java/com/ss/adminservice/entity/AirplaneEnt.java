package com.ss.adminservice.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "airplane")
public class AirplaneEnt {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @org.hibernate.annotations.Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;
    @JoinColumn(nullable = false)
    @ManyToOne(optional = false, targetEntity = AirplaneTypeEnt.class)
    private AirplaneTypeEnt airplaneType;

    public UUID getId() {
        return id;
    }

    public AirplaneEnt setId(UUID id) {
        this.id = id;
        return this;
    }

    public AirplaneTypeEnt getAirplaneType() {
        return airplaneType;
    }

    public AirplaneEnt setAirplaneType(AirplaneTypeEnt airplaneType) {
        this.airplaneType = airplaneType;
        return this;
    }
}
