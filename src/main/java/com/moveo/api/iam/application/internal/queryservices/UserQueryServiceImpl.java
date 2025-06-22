package com.moveo.api.iam.application.internal.queryservices;

import com.moveo.api.iam.domain.model.aggregate.User;
import com.moveo.api.iam.domain.model.queries.GetAllUsersQuery;
import com.moveo.api.iam.domain.model.queries.GetUserByIdQuery;
import com.moveo.api.iam.domain.services.UserQueryService;
import com.moveo.api.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserQueryServiceImpl implements UserQueryService {

    private final UserRepository userRepository;

    public UserQueryServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> handle(GetAllUsersQuery query) {
        return  this.userRepository.findAll();
    }

    @Override
    public Optional<User> handle(GetUserByIdQuery query) {
        return this.userRepository.findById(query.id());
    }
}
