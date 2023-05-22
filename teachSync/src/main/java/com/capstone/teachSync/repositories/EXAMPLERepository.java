package com.capstone.teachSync.repositories;

import com.capstone.teachSync.entities.EXAMPLE;
import com.capstone.teachSync.utils.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface EXAMPLERepository extends
        JpaRepository<EXAMPLE, Long>,
        JpaSpecificationExecutor<EXAMPLE> {

    Page<EXAMPLE> findAllByStatusNot(Status status, Pageable paging);

    /* Id */
    Optional<EXAMPLE> findByExampleIdAndStatusNot(long exampleId, Status status);

    List<EXAMPLE> findAllByExampleIdInAndStatusNot(Collection<Long> exampleIdCollection, Status status);

    /* fkId */
    Optional<EXAMPLE> findByExampleFKIdAndStatusNot(long exampleFKId, Status status);

    List<EXAMPLE> findAllByExampleFKIdAndStatusNot(long exampleFKId, Status status);

    List<EXAMPLE> findAllByExampleFKIdInAndStatusNot(Collection<Long> exampleFKIdCollection, Status status);

    /* Check Duplicate */
    @Query("select case when count(example) > 0 then true else false end from EXAMPLE example " +
            "where example.exampleString = ?1 and example.status <> ?2")
    boolean isDuplicateInsert(String exampleString, Status status);

    @Query("select case when count(example) > 0 then true else false end from EXAMPLE example " +
            "where example.exampleString = ?1 and example.exampleId <> ?2 and example.status <> ?3")
    boolean isDuplicateUpdate(String exampleString, long exampleId, Status status);

}