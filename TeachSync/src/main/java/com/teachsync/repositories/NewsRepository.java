package com.teachsync.repositories;

import com.teachsync.entities.News;
import com.teachsync.utils.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NewsRepository extends JpaRepository<News, Long> {

    News findAllById(Long id);

    Page<News> findAllByStatusNot(Status status, Pageable pageable);

    /* id */
    Optional<News> findByIdAndStatusNot(Long id, Status status);
}
