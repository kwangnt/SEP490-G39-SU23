package com.teachSync.teachSync.repositories;

import com.teachSync.teachSync.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsernameAndPasswordAndStatusNot(String username, String pass, String Status);

    boolean existsByUsernameAndStatusNot(String username, String status);

}
