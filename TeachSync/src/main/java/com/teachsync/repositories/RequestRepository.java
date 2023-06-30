package com.teachsync.repositories;


import com.teachsync.entities.Request;
import com.teachsync.utils.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

    Page<Request> findAllByStatusNot(Status status, Pageable pageable);

}