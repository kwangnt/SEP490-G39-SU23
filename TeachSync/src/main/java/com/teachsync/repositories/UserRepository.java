package com.teachsync.repositories;

import com.teachsync.entities.User;
import com.teachsync.utils.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsernameAndPasswordAndStatusNot(String username, String pass, Status status);

    /* Check duplicate */
    boolean existsByUsernameAndStatusNot(String username, Status status);

    List<User> findAllByRoleId(Long roleId);

    List<User> findAllByUsernameContaining(String username);

    @Query ("SELECT u FROM User u WHERE u.email = ?1")
    public User findByEmail(String email);

    public User findByResetPasswordToken(String token);
}
