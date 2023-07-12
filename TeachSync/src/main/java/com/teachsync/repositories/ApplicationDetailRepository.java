package com.teachsync.repositories;

import com.teachsync.entities.ApplicationDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationDetailRepository extends JpaRepository<ApplicationDetail, Long> {
}