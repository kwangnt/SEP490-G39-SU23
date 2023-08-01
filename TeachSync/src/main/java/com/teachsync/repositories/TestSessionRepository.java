package com.teachsync.repositories;

import com.teachsync.entities.TestSession;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestSessionRepository extends JpaRepository<TestSession, Long> {
    Page<TestSession> findAllByOrderByStartDateDesc(Pageable pageable);

    TestSession findAllByUsernameAndStatusNotAndTestId(String userName, int status, Long testid);
}
