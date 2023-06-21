package com.teachsync.repositories;

import com.teachsync.entities.Attendant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendantRepository extends JpaRepository<Attendant, Long> {
}