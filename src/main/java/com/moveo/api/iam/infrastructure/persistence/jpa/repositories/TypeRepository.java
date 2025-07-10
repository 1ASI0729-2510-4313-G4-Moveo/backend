package com.moveo.api.iam.infrastructure.persistence.jpa.repositories;

import com.moveo.api.iam.domain.model.entities.Type;
import com.moveo.api.iam.domain.model.valueobjects.Types;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * This interface is responsible for providing the Type entity related operations.
 * It extends the JpaRepository interface.
 */
@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {

    /**
     * This method is responsible for finding the type by name.
     * @param name The type name.
     * @return The type object.
     */
    Optional<Type> findByName(Types name);

    /**
     * This method is responsible for checking if the type exists by name.
     * @param name The type name.
     * @return True if the type exists, false otherwise.
     */
    boolean existsByName(Types name);

} 