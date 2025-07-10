package com.moveo.api.iam.domain.services;

import com.moveo.api.iam.domain.model.entities.Type;
import com.moveo.api.iam.domain.model.queries.GetAllTypesQuery;
import com.moveo.api.iam.domain.model.queries.GetTypeByNameQuery;

import java.util.List;
import java.util.Optional;

/**
 * Type query service
 * <p>
 *     This interface represents the service that handles the type queries.
 * </p>
 */
public interface TypeQueryService {
    /**
     * Handle get all types query
     * @param query the {@link GetAllTypesQuery} query
     * @return a list of {@link Type} entities
     */
    List<Type> handle(GetAllTypesQuery query);

    /**
     * Handle get type by name query
     * @param query the {@link GetTypeByNameQuery} query
     * @return an {@link Optional} of {@link Type} entity
     */
    Optional<Type> handle(GetTypeByNameQuery query);
} 