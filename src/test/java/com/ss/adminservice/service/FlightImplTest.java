package com.ss.adminservice.service;


import com.ss.adminservice.dto.Flight;
import com.ss.adminservice.repo.FlightRepo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FlightImplTest {

    TestRestTemplate restTemplate;
    HttpHeaders headers;
    @Autowired
    FlightRepo flightRepo;
    @LocalServerPort
    private int port;


    public FlightImplTest() {
        restTemplate = new TestRestTemplate();
        headers = new HttpHeaders();
    }

    @Test
    void addFlight() {
        //get list of all flights
        headers.clear();
        ResponseEntity<Flight[]> getResponse =
                restTemplate.getForEntity(getUrl("/flight"), Flight[].class);

        assertTrue(Objects.requireNonNull(getResponse.getBody()).length > 0);

        //sample flight for other methods
        Flight flight = getResponse.getBody()[0];

        //update flight
        flight.setReservedSeats(69);

        headers.clear();
        headers.add("Content-Type", "application/json");
        HttpEntity<Flight> updateEnt = new HttpEntity<>(flight, headers);
        ResponseEntity<Flight> updateResponse = restTemplate.exchange(
                getUrl("/flight/" + flight.getId()), HttpMethod.POST, updateEnt, Flight.class);

        //check update
        headers.clear();
        HttpEntity<String> entity = new HttpEntity<>("", headers);
        ResponseEntity<Flight> searchResponse = restTemplate.exchange(
                getUrl("/flight/" + flight.getId()), HttpMethod.GET, entity, Flight.class
        );
        assertEquals(flight, searchResponse.getBody());


        //delete sample flight
        headers.clear();
        entity = new HttpEntity<>("", headers);
        ResponseEntity<String> deleteResponse = restTemplate.exchange(
                getUrl("/flight/" + flight.getId()), HttpMethod.DELETE, entity, String.class
        );
        assertEquals(deleteResponse.getStatusCode(), HttpStatus.OK);

        //verify flight is deleted
        headers.clear();
        entity = new HttpEntity<>("", headers);
        searchResponse = restTemplate.exchange(
                getUrl("/flight/" + flight.getId()), HttpMethod.GET, entity, Flight.class
        );
        assertEquals(searchResponse.getStatusCode(), HttpStatus.BAD_REQUEST);

        //add flight
        headers.clear();
        headers.add("Content-Type", "application/json");
        HttpEntity<Flight> fEntity = new HttpEntity<>(flight, headers);
        ResponseEntity<Flight> addResponse = restTemplate.exchange(
                getUrl("/flight"), HttpMethod.PUT, fEntity, Flight.class);
        assertEquals(getResponse.getStatusCode(), HttpStatus.OK);

        //search flight again
        headers.clear();
        entity = new HttpEntity<>("", headers);
        searchResponse = restTemplate.exchange(
                getUrl("/flight/" + Objects.requireNonNull(addResponse.getBody()).getId()), HttpMethod.GET, entity, Flight.class
        );
        flight.setId(null);
        Objects.requireNonNull(searchResponse.getBody()).setId(null);
        assertEquals(flight, searchResponse.getBody());
    }

    @Test
    void allFlights() {
        headers.clear();
        HttpEntity<String> entity = new HttpEntity<>("", headers);
        ResponseEntity<String> response = restTemplate.exchange(
                getUrl("/flight"), HttpMethod.GET, entity, String.class
        );
        assertTrue(Objects.requireNonNull(response.getBody()).length() > 1); //at least returned an empty array
    }


    private String getUrl(String path) {
        return "http://localhost:" + port + path;
    }
}