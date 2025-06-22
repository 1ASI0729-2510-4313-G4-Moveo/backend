package com.moveo.api.iam.domain.services;

import com.moveo.api.iam.domain.model.aggregate.User;
import com.moveo.api.iam.domain.model.commands.CreateUserCommand;

import java.util.Optional;

public interface UserCommandService {

    Optional<User> handle(CreateUserCommand createUserCommand);
}
