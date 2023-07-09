package com.teachsync.repositories;

import com.teachsync.entities.Center;
import com.teachsync.utils.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface CenterRepository extends JpaRepository<Center, Long> {

    List<Center> findAllByStatusNot(Status status);

    /* id */
    Optional<Center> findByIdAndStatusNot(Long id, Status status);
    List<Center> findAllByIdInAndStatusNot(Collection<Long> idCollection, Status status);
}