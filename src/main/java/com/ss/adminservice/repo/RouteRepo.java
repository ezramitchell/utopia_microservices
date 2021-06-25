package com.ss.adminservice.repo;

import com.ss.adminservice.entity.RouteEnt;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RouteRepo extends CrudRepository<RouteEnt, UUID> {
}
