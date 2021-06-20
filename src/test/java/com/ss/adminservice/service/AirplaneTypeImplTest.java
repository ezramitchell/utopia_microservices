package com.ss.adminservice.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
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
class AirplaneTypeImplTest {

    TestRestTemplate restTemplate;
    String airplaneType;
    HttpHeaders headers;
    @LocalServerPort
    private int port;


    public AirplaneTypeImplTest() {
        airplaneType = """
                {
                	"id": null,
                	"maxCapacity": 48
                }
                """;
        restTemplate = new TestRestTemplate();
        headers = new HttpHeaders();
    }

    @Test
    void addType() {
        headers.clear();
        headers.add("Content-Type", "application/json");
        HttpEntity<String> entity = new HttpEntity<>(airplaneType, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                getUrl("/airplane_type"), HttpMethod.PUT, entity, String.class);

        assertEquals(response.getStatusCode(), HttpStatus.OK);

    }

    @Test
    void allTypes() {
        headers.clear();
        HttpEntity<String> entity = new HttpEntity<>("", headers);

        ResponseEntity<String> response = restTemplate.exchange(
                getUrl("/airplane_type"), HttpMethod.GET, entity, String.class
        );

        assertTrue(Objects.requireNonNull(response.getBody()).length() > 1); //at least returned an empty array
    }


    private String getUrl(String path) {
        return "http://localhost:" + port + path;
    }
}