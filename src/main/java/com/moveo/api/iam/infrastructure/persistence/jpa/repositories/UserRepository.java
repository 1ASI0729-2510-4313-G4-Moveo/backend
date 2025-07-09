package com.moveo.api.iam.infrastructure.persistence.jpa.repositories;

import com.moveo.api.iam.domain.model.aggregates.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * This interface is responsible for providing the User entity related operations.
 * It extends the JpaRepository interface.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
    /**
     * This method is responsible for finding the user by email.
     * @param email The email.
     * @return The user object.
     */
    Optional<User> findByEmail(String email);

    /**
     * This method is responsible for checking if the user exists by email.
     * @param email The email.
     * @return True if the user exists, false otherwise.
     */
    boolean existsByEmail(String email);

    /**
     * This method is responsible for finding all users with their types loaded.
     * @return List of users with types loaded.
     */
    @Query("SELECT DISTINCT u FROM User u LEFT JOIN FETCH u.types")
    List<User> findAllWithTypes();

    /**
     * This method is responsible for finding a user by id with their types loaded.
     * @param id The user id.
     * @return Optional of user with types loaded.
     */
    @Query("SELECT u FROM User u LEFT JOIN FETCH u.types WHERE u.id = :id")
    Optional<User> findByIdWithTypes(Long id);

    /**
     * This method is responsible for finding a user by email with their types loaded.
     * @param email The email.
     * @return Optional of user with types loaded.
     */
    @Query("SELECT u FROM User u LEFT JOIN FETCH u.types WHERE u.email = :email")
    Optional<User> findByEmailWithTypes(String email);

}
