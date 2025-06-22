package com.moveo.api.iam.domain.services;

import com.moveo.api.iam.domain.model.aggregate.User;
import com.moveo.api.iam.domain.model.queries.GetAllUsersQuery;
import com.moveo.api.iam.domain.model.queries.GetUserByIdQuery;

import java.util.List;
import java.util.Optional;

public interface UserQueryService {
    List<User> handle(GetAllUsersQuery query);
    Optional<User> handle(GetUserByIdQuery query);
}
