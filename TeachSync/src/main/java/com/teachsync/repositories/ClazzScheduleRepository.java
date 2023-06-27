package com.teachsync.repositories;

import com.teachsync.entities.ClazzSchedule;
import com.teachsync.utils.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface ClazzScheduleRepository extends JpaRepository<ClazzSchedule, Long> {

    /* clazzId */
    Optional<ClazzSchedule> findByClazzIdAndStatusNot(Long clazzId, Status status);
    List<ClazzSchedule> findAllByClazzIdInAndStatusNot(Collection<Long> clazzIdCollection, Status status);
}