package com.ss.adminservice.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "flight")
public class FlightEnt {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @org.hibernate.annotations.Type(type="org.hibernate.type.UUIDCharType")
    private UUID id;
    @JoinColumn(nullable = false)
    @ManyToOne(optional = false, targetEntity = RouteEnt.class)
    private RouteEnt route;
    @JoinColumn(nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = AirplaneEnt.class)
    private AirplaneEnt airplane;
    @OneToMany(targetEntity = BookingEnt.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "flight")
    private List<BookingEnt> bookings;
    @Column(nullable = false)
    private ZonedDateTime departureTime;
    @Column(nullable = false)
    private int reservedSeats;
    @Column(nullable = false)
    private float seatPrice;

    public FlightEnt setId(UUID id) {
        this.id = id;
        return this;
    }

    public UUID getId() {
        return id;
    }

    public RouteEnt getRoute() {
        return route;
    }

    public FlightEnt setRoute(RouteEnt route) {
        this.route = route;
        return this;
    }

    public AirplaneEnt getAirplane() {
        return airplane;
    }

    public FlightEnt setAirplane(AirplaneEnt airplane) {
        this.airplane = airplane;
        return this;
    }

    public List<BookingEnt> getBookings() {
        return bookings;
    }

    public FlightEnt setBookings(List<BookingEnt> bookings) {
        this.bookings = bookings;
        return this;
    }

    public ZonedDateTime getDepartureTime() {
        return departureTime;
    }

    public FlightEnt setDepartureTime(ZonedDateTime departureTime) {
        this.departureTime = departureTime;
        return this;
    }

    public int getReservedSeats() {
        return reservedSeats;
    }

    public FlightEnt setReservedSeats(int reservedSeats) {
        this.reservedSeats = reservedSeats;
        return this;
    }

    public float getSeatPrice() {
        return seatPrice;
    }

    public FlightEnt setSeatPrice(float seatPrice) {
        this.seatPrice = seatPrice;
        return this;
    }
}
