package com.teachsync.repositories;


import com.teachsync.entities.TeacherRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TeacherRequestRepository extends JpaRepository<TeacherRequest, Long> {

}