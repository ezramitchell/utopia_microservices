package com.ss.adminservice.repo;

import com.ss.adminservice.entity.AirportEnt;
import org.springframework.data.repository.CrudRepository;

public interface AirportRepo extends CrudRepository<AirportEnt, String> {
}
