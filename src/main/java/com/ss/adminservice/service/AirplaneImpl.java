package com.ss.adminservice.service;

import com.ss.adminservice.api.AirplaneApi;
import com.ss.adminservice.api.AirplaneApiDelegate;
import com.ss.adminservice.dto.Airplane;
import com.ss.adminservice.entity.AirplaneEnt;
import com.ss.adminservice.entity.AirplaneTypeEnt;
import com.ss.adminservice.repo.AirplaneRepo;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AirplaneImpl implements AirplaneApiDelegate {
    private final AirplaneRepo airplaneRepo;
    private final ModelMapper modelMapper;

    public AirplaneImpl(AirplaneRepo airplaneRepo, ModelMapper modelMapper) {
        this.airplaneRepo = airplaneRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return AirplaneApiDelegate.super.getRequest();
    }

    /**
     * PUT /airplane
     * add airplane
     *
     * @param airplane (optional)
     * @return add successful (status code 200)
     * or add failed (status code 400)
     * @see AirplaneApi#addAirplane
     */
    @Override
    public ResponseEntity<Void> addAirplane(Airplane airplane) {
        try {
            if (airplane.getId() == null) {
                airplaneRepo.save(convertToEntity(airplane));
                return ResponseEntity.ok(null);
            }
        } catch (Exception ignored) {
        }
        return ResponseEntity.badRequest().body(null);
    }

    /**
     * GET /airplane/{airplaneId}
     * get airplane at id
     *
     * @param airplaneId (required)
     * @return returns airplane (status code 200)
     * @see AirplaneApi#getAirplane
     */
    @Override
    public ResponseEntity<Airplane> getAirplane(String airplaneId) {
        Optional<AirplaneEnt> airplaneEnt = airplaneRepo.findById(UUID.fromString(airplaneId));
        return airplaneEnt.map(ent -> ResponseEntity.ok(convertToDTO(ent)))
                .orElseGet(() -> ResponseEntity.badRequest().body(null));
    }

    /**
     * GET /airplane
     * get all airplanes
     *
     * @return list of airplanes (status code 200)
     * @see AirplaneApi#getAllAirplanes
     */
    @Override
    public ResponseEntity<List<Airplane>> getAllAirplanes() {
        List<Airplane> planes = new ArrayList<>();
        airplaneRepo.findAll().forEach(ent -> planes.add(convertToDTO(ent)));
        return new ResponseEntity<>(planes, HttpStatus.OK);
    }

    /**
     * POST /airplane/{airplaneId}
     * update airplane
     *
     * @param airplaneId (required)
     * @param airplane   (optional)
     * @return update succesful (status code 200)
     * or update failed (status code 400)
     * @see AirplaneApi#updateAirplane
     */
    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.NESTED)
    public ResponseEntity<Void> updateAirplane(String airplaneId, Airplane airplane) {
        Optional<AirplaneEnt> ent = airplaneRepo.findById(UUID.fromString(airplaneId));
        if (ent.isPresent()) {
            modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
            airplane.setId(null);
            modelMapper.map(ent, convertToEntity(airplane));
        }
        return ResponseEntity.badRequest().body(null);
    }


    private AirplaneEnt convertToEntity(Airplane airplane) {
        AirplaneEnt ent = modelMapper.map(airplane, AirplaneEnt.class);
        ent.setAirplaneType(new AirplaneTypeEnt()
                .setId(UUID.fromString(airplane.getAirplaneType().getId())));
        return ent;
    }

    private Airplane convertToDTO(AirplaneEnt airplaneEnt) {
        return modelMapper.map(airplaneEnt, Airplane.class);
    }

}
