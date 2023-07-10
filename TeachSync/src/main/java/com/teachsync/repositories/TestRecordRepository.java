package com.teachsync.repositories;

import com.teachsync.entities.TestRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRecordRepository extends JpaRepository<TestRecord, Long> {
}