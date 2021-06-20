package com.ss.adminservice.service;

import com.ss.adminservice.api.AirportApi;
import com.ss.adminservice.api.AirportApiDelegate;
import com.ss.adminservice.dto.Airport;
import com.ss.adminservice.entity.AirportEnt;
import com.ss.adminservice.repo.AirportRepo;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AirportImpl implements AirportApiDelegate {
    private final AirportRepo airportRepo;
    private final ModelMapper modelMapper;

    public AirportImpl(AirportRepo airportRepo, ModelMapper modelMapper) {
        this.airportRepo = airportRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return AirportApiDelegate.super.getRequest();
    }

    /**
     * DELETE /airport/{iataId}
     * Delete airport
     *
     * @param iataId (required)
     * @return Delete succeeded (status code 200)
     * or Delete failed (status code 400)
     * @see AirportApi#deleteAirport
     */
    @Override
    public ResponseEntity<Void> deleteAirport(String iataId) {
        System.out.println(iataId);
        try {
            airportRepo.deleteById(iataId);
            return ResponseEntity.ok(null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ResponseEntity.badRequest().body(null);
    }

    /**
     * PUT /airport : Add airport
     *
     * @param airport (optional)
     * @return Add successful (status code 200)
     * or Add failed (status code 400)
     * @see AirportApi#addAirport
     */
    @Override
    public ResponseEntity<Void> addAirport(Airport airport) {
        try {
            airportRepo.save(convertToEntity(airport));
            return ResponseEntity.ok(null);
        } catch (Exception ignored) {
        }
        return ResponseEntity.badRequest().body(null);
    }

    /**
     * GET /airport : get All airports
     *
     * @return list of airports (status code 200)
     * or no airports/failed (status code 400)
     * @see AirportApi#getAllAirports
     */
    @Override
    public ResponseEntity<List<Airport>> getAllAirports() {
        List<Airport> airports = new ArrayList<>();
        airportRepo.findAll().forEach(ent -> airports.add(convertToDTO(ent)));
        return new ResponseEntity<>(airports, HttpStatus.OK);
    }

    private AirportEnt convertToEntity(Airport airport) {
        return modelMapper.map(airport, AirportEnt.class);
    }

    private Airport convertToDTO(AirportEnt ent) {
        return modelMapper.map(ent, Airport.class);
    }
}
