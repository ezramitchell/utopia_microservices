package com.ss.adminservice.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "booking")
public class BookingEnt {
    @Id
    @GeneratedValue(generator = "UUID")
    @org.hibernate.annotations.Type(type="org.hibernate.type.UUIDCharType")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column(nullable = false)
    private boolean active;
    @Column(nullable = false)
    private String confirmationCode;
    @Embedded
    private PassengerEnt passenger;
    @ManyToOne(targetEntity = UserEnt.class, fetch = FetchType.LAZY)
    private UserEnt user;
    @Embedded
    private BookingPaymentEnt payment;
    @ManyToOne(targetEntity = FlightEnt.class, fetch = FetchType.LAZY)
    private FlightEnt flight;


    public PassengerEnt getPassenger() {
        return passenger;
    }

    public UUID getId() {
        return id;
    }

    public BookingEnt setId(UUID id) {
        this.id = id;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public BookingEnt setActive(boolean active) {
        this.active = active;
        return this;
    }

    public String getConfirmationCode() {
        return confirmationCode;
    }

    public BookingEnt setConfirmationCode(String confirmationCode) {
        this.confirmationCode = confirmationCode;
        return this;
    }

    public BookingEnt setPassenger(PassengerEnt passenger) {
        this.passenger = passenger;
        return this;
    }

    public UserEnt getUser() {
        return user;
    }

    public BookingEnt setUser(UserEnt user) {
        this.user = user;
        return this;
    }

    public BookingPaymentEnt getPayment() {
        return payment;
    }

    public BookingEnt setPayment(BookingPaymentEnt payment) {
        this.payment = payment;
        return this;
    }

    public FlightEnt getFlight() {
        return flight;
    }

    public BookingEnt setFlight(FlightEnt flight) {
        this.flight = flight;
        return this;
    }
}
