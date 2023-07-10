package com.teachsync.repositories;

import com.teachsync.entities.CampaignApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignApplicationRepository extends JpaRepository<CampaignApplication, Long> {
}