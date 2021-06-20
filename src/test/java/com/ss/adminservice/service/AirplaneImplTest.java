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
class AirplaneImplTest {

    TestRestTemplate restTemplate;
    String airplaneType;
    HttpHeaders headers;
    @LocalServerPort
    private int port;


    public AirplaneImplTest() {
        airplaneType = """
                {
                	"id": null,
                	"airplaneType": {
                    "id": "202484c7-8700-41a6-a727-df7e93786cf3"
                  }
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
                getUrl("/airplane"), HttpMethod.PUT, entity, String.class);

        assertEquals(response.getStatusCode(), HttpStatus.OK);

//        entity = new HttpEntity<>(airplaneType, headers);
//
//        response = restTemplate.exchange(
//                getUrl("/airplane/"), HttpMethod.DELETE, entity, String.class);
//
//        assertEquals(response.getStatusCode(), HttpStatus.OK);
        //TODO add return value to add methods
    }

    @Test
    void allTypes() {
        headers.clear();
        HttpEntity<String> entity = new HttpEntity<>("", headers);

        ResponseEntity<String> response = restTemplate.exchange(
                getUrl("/airplane"), HttpMethod.GET, entity, String.class
        );

        assertTrue(Objects.requireNonNull(response.getBody()).length() > 1); //at least returned an empty array
    }


    private String getUrl(String path) {
        return "http://localhost:" + port + path;
    }
}