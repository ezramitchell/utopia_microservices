package com.ss.adminservice.repo;

import com.ss.adminservice.entity.AirplaneEnt;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AirplaneRepo extends CrudRepository<AirplaneEnt, UUID> {
}

