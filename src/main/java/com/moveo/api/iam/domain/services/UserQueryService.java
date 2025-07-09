package com.moveo.api.iam.domain.services;

import com.moveo.api.iam.domain.model.aggregates.User;
import com.moveo.api.iam.domain.model.queries.GetAllUsersQuery;
import com.moveo.api.iam.domain.model.queries.GetUserByEmailQuery;
import com.moveo.api.iam.domain.model.queries.GetUserByIdQuery;

import java.util.List;
import java.util.Optional;

/**
 * User query service
 * <p>
 *     This interface represents the service to handle user queries.
 * </p>
 */
public interface UserQueryService {
    /**
     * Handle get all users query
     * @param query the {@link GetAllUsersQuery} query
     * @return a list of {@link User} entities
     */
    List<User> handle(GetAllUsersQuery query);

    /**
     * Handle get user by id query
     * @param query the {@link GetUserByIdQuery} query
     * @return an {@link Optional} of {@link User} entity
     */
    Optional<User> handle(GetUserByIdQuery query);

    /**
     * Handle get user by username query
     * @param query the {@link GetUserByEmailQuery} query
     * @return an {@link Optional} of {@link User} entity
     */
    Optional<User> handle(GetUserByEmailQuery query);

}
