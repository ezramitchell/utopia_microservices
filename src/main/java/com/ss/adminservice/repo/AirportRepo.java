package com.ss.adminservice.repo;

import com.ss.adminservice.entity.AirportEnt;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AirportRepo extends CrudRepository<AirportEnt, String> {
}
