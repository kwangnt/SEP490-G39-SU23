package com.teachsync.repositories;

import com.teachsync.entities.Room;
import com.teachsync.utils.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {

    /* id */
    Optional<Room> findByIdAndStatusNot(Long id, Status status);
    List<Room> findAllByIdInAndStatusNot(Collection<Long> idCollection, Status status);
}