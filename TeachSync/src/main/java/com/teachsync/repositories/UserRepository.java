package com.teachsync.repositories;

import com.teachsync.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsernameAndPasswordAndStatusNot(String username, String pass, String Status);

    /* Check duplicate */
    boolean existsByUsernameAndStatusNot(String username, String status);

}