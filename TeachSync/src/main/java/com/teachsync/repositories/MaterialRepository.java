package com.teachsync.repositories;


import com.teachsync.entities.Material;
import com.teachsync.utils.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface MaterialRepository extends JpaRepository<Material, Long> {
    Material findAllById(Long id);

    Page<Material> findAllByStatusNot(Status status, Pageable pageable);

    /* id */
    Optional<Material> findByIdAndStatusNot(Long id, Status status);

    List<Material> findAllByIdInAndStatusNot(Collection<Long> idCollection, Status status);
}
