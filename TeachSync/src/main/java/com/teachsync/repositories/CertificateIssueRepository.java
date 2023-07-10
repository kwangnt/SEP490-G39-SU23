package com.teachsync.repositories;

import com.teachsync.entities.CertificateIssue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateIssueRepository extends JpaRepository<CertificateIssue, Long> {
}