package com.teachsync.repositories;

import com.teachsync.entities.Semester;
import com.teachsync.utils.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface SemesterRepository extends JpaRepository<Semester, Long> {
    
    Page<Semester> findAllByStatusNot(Status status, Pageable paging);
    
    /* id */
    Optional<Semester> findByIdAndStatusNot(Long id, Status status);
    List<Semester> findAllByIdInAndStatusNot(Collection<Long> idCollection, Status status);
    
    /* startDate */
    /** Tmp function */
    List<Semester> findAllByStartDateAfterAndStatusNot(LocalDate dateTime, Status status);
}