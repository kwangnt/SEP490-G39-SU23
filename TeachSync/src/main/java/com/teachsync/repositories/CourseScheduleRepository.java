package com.teachsync.repositories;

import com.teachsync.entities.CourseSchedule;
import com.teachsync.utils.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface CourseScheduleRepository extends JpaRepository<CourseSchedule, Long> {

    Page<CourseSchedule> findAllByStatusNot(Status status, Pageable pageable);

    /* id */
    Optional<CourseSchedule> findByIdAndStatusNot(long id, Status status);
    List<CourseSchedule> findAllByIdInAndStatusNot(Collection<Long> idCollection, Status status);

    /* courseId */
    /** Tmp function */
    Optional<CourseSchedule> findFirstByCourseIdAndStatusNotOrderByStartDateDesc(long courseId, Status status);


    /* Check duplicate */

}