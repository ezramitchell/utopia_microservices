package com.ss.adminservice.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "user")
public class UserEnt {
    @Id
    @GeneratedValue(generator = "UUID")
    @org.hibernate.annotations.Type(type = "org.hibernate.type.UUIDCharType")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column(nullable = false)
    private String userRole;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, unique = true)
    private String phone;
    @Column(nullable = false)
    private boolean enabled;
    @OneToMany(targetEntity = BookingEnt.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private List<BookingEnt> bookings;

    public UUID getId() {
        return id;
    }

    public UserEnt setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getUserRole() {
        return userRole;
    }

    public UserEnt setUserRole(String userRole) {
        this.userRole = userRole;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserEnt setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserEnt setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserEnt setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEnt setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEnt setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserEnt setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public List<BookingEnt> getBookings() {
        return bookings;
    }

    public UserEnt setBookings(List<BookingEnt> bookings) {
        this.bookings = bookings;
        return this;
    }
}
