package com.teachsync.repositories;

import com.teachsync.entities.LocationUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationUnitRepository extends JpaRepository<LocationUnit, Long> {
}