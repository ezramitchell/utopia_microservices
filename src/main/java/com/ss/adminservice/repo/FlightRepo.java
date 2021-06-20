package com.ss.adminservice.repo;

import com.ss.adminservice.entity.FlightEnt;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface FlightRepo extends CrudRepository<FlightEnt, UUID> {
}
