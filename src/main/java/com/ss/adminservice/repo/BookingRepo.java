package com.ss.adminservice.repo;

import com.ss.adminservice.entity.BookingEnt;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface BookingRepo extends CrudRepository<BookingEnt, UUID> {
    @Query("SELECT b FROM BookingEnt b WHERE b.user.id = ?1")
    Iterable<BookingEnt> findByUserId(UUID userId);
}
