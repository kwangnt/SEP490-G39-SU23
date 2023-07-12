package com.teachsync.repositories;

import com.teachsync.entities.RecruitmentCampaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruitmentCampaignRepository extends JpaRepository<RecruitmentCampaign, Long> {
}