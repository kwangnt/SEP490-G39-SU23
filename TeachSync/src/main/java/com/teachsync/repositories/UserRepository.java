package com.teachsync.repositories;

import com.teachsync.entities.User;
import com.teachsync.utils.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsernameAndStatusNot(String username, Status status);

    /**
     * For finding unactivated teacher
     */
    Optional<User> findByIdAndStatus(Long id, Status status);

    /* Check duplicate */
    boolean existsByUsernameAndStatusNot(String username, Status status);

    boolean existsByEmailAndStatusNot(String email, Status status);

    List<User> findAllByRoleId(Long roleId);

    List<User> findAllByUsernameContaining(String username);

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public User findByEmail(String email);

    public User findByResetPasswordToken(String token);

    Optional<User> findByIdAndStatusNot(Long id, Status status);

    User findUsersById(Long id);
}

