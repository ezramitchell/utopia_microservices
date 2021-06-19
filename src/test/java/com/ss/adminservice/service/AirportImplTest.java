package com.ss.adminservice.service;


import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
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
class AirportImplTest {

    TestRestTemplate restTemplate;
    String airport;
    HttpHeaders headers;
    @LocalServerPort
    private int port;


    public AirportImplTest() {
        airport = """
                {
                \t"iataId": "AAA",
                \t"city": "reserved"
                }""";
        restTemplate = new TestRestTemplate();
        headers = new HttpHeaders();
    }

    @Test
    @Order(3)
    void addDeleteAirport() {
        headers.clear();
        headers.add("Content-Type", "application/json");
        HttpEntity<String> entity = new HttpEntity<>(airport, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                getUrl("/airport"), HttpMethod.PUT, entity, String.class);

        assertEquals(response.getStatusCode(), HttpStatus.OK);

        headers.clear();

        entity = new HttpEntity<>("", headers);

        response = restTemplate.exchange(
                getUrl("/airport/AAA"), HttpMethod.DELETE, entity, String.class
        );

        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    @Order(2)
    void AllAirports() {
        headers.clear();
        HttpEntity<String> entity = new HttpEntity<>("", headers);

        ResponseEntity<String> response = restTemplate.exchange(
                getUrl("/airport"), HttpMethod.GET, entity, String.class
        );

        assertTrue(Objects.requireNonNull(response.getBody()).length() > 1); //at least returned an empty array
    }


    private String getUrl(String path) {
        return "http://localhost:" + port + path;
    }
}