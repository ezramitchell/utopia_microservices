package com.ss.adminservice.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PassengerEnt {

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false)
    private String address;



    public String getFirstName() {
        return firstName;
    }

    public PassengerEnt setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public PassengerEnt setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public PassengerEnt setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public PassengerEnt setAddress(String address) {
        this.address = address;
        return this;
    }
}
