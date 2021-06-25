package com.ss.adminservice.service;

import com.ss.adminservice.api.FlightApi;
import com.ss.adminservice.api.FlightApiDelegate;
import com.ss.adminservice.dto.Flight;
import com.ss.adminservice.entity.FlightEnt;
import com.ss.adminservice.repo.FlightRepo;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;

import javax.ws.rs.HeaderParam;
import java.util.ArrayList;
import java.util.List;

public class FlightImpl implements FlightApiDelegate {

    private FlightRepo flightRepo;
    private ModelMapper modelMapper;

    public FlightImpl(FlightRepo flightRepo, ModelMapper modelMapper) {
        this.flightRepo = flightRepo;
        this.modelMapper = modelMapper;
    }



    /**
     * GET /flight
     * get all flights
     *
     * @param authorization (required)
     * @return list of flights (status code 200)
     * or failed (status code 400)
     * @see FlightApi#getAllFlights
     */
    @Override
    public ResponseEntity<List<Flight>> getAllFlights(String authorization) {
        List<Flight> flights = new ArrayList<>();
        flightRepo.findAll().forEach(ent -> flights.add(convertToDTO(ent)));
        return ResponseEntity.ok(flights);
    }

    private Flight convertToDTO(FlightEnt ent){
        return modelMapper.map(ent, Flight.class);
    }
}
