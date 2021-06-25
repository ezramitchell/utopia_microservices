package com.ss.adminservice.repo;

import com.ss.adminservice.entity.AirplaneTypeEnt;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AirplaneTypeRepo extends CrudRepository<AirplaneTypeEnt, UUID> {
}
