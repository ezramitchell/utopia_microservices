package com.ss.adminservice.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "route")
public class RouteEnt {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @org.hibernate.annotations.Type(type="org.hibernate.type.UUIDCharType")
    private UUID id;
    @JoinColumn(nullable = false)
    @ManyToOne(optional = false, targetEntity = AirportEnt.class, fetch = FetchType.EAGER)
    private AirportEnt originAirport;
    @JoinColumn(nullable = false)
    @ManyToOne(optional = false, targetEntity = AirportEnt.class, fetch = FetchType.EAGER)
    private AirportEnt destinationAirport;

    public UUID getId() {
        return id;
    }

    public RouteEnt setId(UUID id) {
        this.id = id;
        return this;
    }

    public AirportEnt getOriginAirport() {
        return originAirport;
    }

    public RouteEnt setOriginAirport(AirportEnt originAirport) {
        this.originAirport = originAirport;
        return this;
    }

    public AirportEnt getDestinationAirport() {
        return destinationAirport;
    }

    public RouteEnt setDestinationAirport(AirportEnt destinationAirport) {
        this.destinationAirport = destinationAirport;
        return this;
    }
}
