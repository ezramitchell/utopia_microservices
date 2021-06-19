package com.ss.adminservice.service;

import com.ss.adminservice.api.AirplaneTypeApi;
import com.ss.adminservice.api.AirplaneTypeApiDelegate;
import com.ss.adminservice.dto.AirplaneType;
import com.ss.adminservice.entity.AirplaneTypeEnt;
import com.ss.adminservice.repo.AirplaneTypeRepo;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AirplaneTypeImpl implements AirplaneTypeApiDelegate {
    @Override
    public Optional<NativeWebRequest> getRequest() {
        return AirplaneTypeApiDelegate.super.getRequest();
    }

    private final AirplaneTypeRepo airplaneTypeRepo;
    private final ModelMapper modelMapper;

    public AirplaneTypeImpl(AirplaneTypeRepo airplaneTypeRepo, ModelMapper modelMapper) {
        this.airplaneTypeRepo = airplaneTypeRepo;
        this.modelMapper = modelMapper;
    }

    /**
     * PUT /airplane_type
     * add airplanetype
     *
     * @param airplaneType (optional)
     * @return add successful (status code 200)
     * or add failed (status code 400)
     * @see AirplaneTypeApi#addAirplaneType
     */
    @Override
    public ResponseEntity<Void> addAirplaneType(AirplaneType airplaneType) {
        try{
            if(airplaneType.getId() == null){
                airplaneTypeRepo.save(convertToEntity(airplaneType));
                return ResponseEntity.ok(null);
            }
        }catch (Exception ignored){
        }
        return ResponseEntity.badRequest().body(null);
    }

    /**
     * GET /airplane_type
     * get all airplane types
     *
     * @return list of airplane types (status code 200)
     * @see AirplaneTypeApi#getAllAirplaneTypes
     */
    @Override
    public ResponseEntity<List<AirplaneType>> getAllAirplaneTypes() {
        List<AirplaneType> types = new ArrayList<>();
        airplaneTypeRepo.findAll().forEach(ent -> types.add(convertToDTO(ent)));
        return new ResponseEntity<>(types, HttpStatus.OK);
    }


    private AirplaneTypeEnt convertToEntity(AirplaneType airplaneType) {
        return modelMapper.map(airplaneType, AirplaneTypeEnt.class);
    }

    private AirplaneType convertToDTO(AirplaneTypeEnt airplaneTypeEnt){
        return modelMapper.map(airplaneTypeEnt, AirplaneType.class);
    }
}
