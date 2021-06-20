package com.ss.adminservice.repo;

import com.ss.adminservice.entity.UserEnt;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepo extends CrudRepository<UserEnt, UUID> {
    Optional<UserEnt> findByEmail(String email);
}
