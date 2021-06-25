package com.ss.adminservice.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "airplane_type")
public class AirplaneTypeEnt {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @org.hibernate.annotations.Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;
    @Column(nullable = false)
    private int maxCapacity;

    public UUID getId() {
        return id;
    }

    public AirplaneTypeEnt setId(UUID id) {
        this.id = id;
        return this;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public AirplaneTypeEnt setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        return this;
    }
}
