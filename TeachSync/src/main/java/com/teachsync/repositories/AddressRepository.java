package com.teachsync.repositories;

import com.teachsync.entities.Address;
import com.teachsync.utils.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    Optional<Address> findByIdAndStatusNot(Long id, Status status);

    List<Address> findAllByIdInAndStatusNot(Collection<Long> idCollection, Status status);


}