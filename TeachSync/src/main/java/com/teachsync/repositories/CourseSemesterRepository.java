package com.teachsync.repositories;

import com.teachsync.entities.CourseSemester;
import com.teachsync.utils.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface CourseSemesterRepository extends JpaRepository<CourseSemester, Long> {

    Page<CourseSemester> findAllByStatusNot(Status status, Pageable pageable);
    List<CourseSemester> findAllByStatusNot(Status status);

    /* id */
    Optional<CourseSemester> findByIdAndStatusNot(long id, Status status);
    List<CourseSemester> findAllByIdInAndStatusNot(Collection<Long> idCollection, Status status);

    /* courseId */
    List<CourseSemester> findAllByCourseIdAndStatusNot(Long courseId, Status status);

    List<CourseSemester> findAllByCourseIdAndSemesterIdInAndStatusNot(
            Long courseId, Collection<Long> semesterIdCollection, Status status);

    /* semesterId */
    List<CourseSemester> findAllBySemesterIdAndStatusNot(Long semesterId, Status status);

    List<CourseSemester> findAllBySemesterIdInAndStatusNot(Collection<Long> semesterIdCollection, Status status);

    /** Tmp function */
    Optional<CourseSemester> findFirstByCourseIdAndStatusNot(long courseId, Status status);


    /* Check duplicate */

}