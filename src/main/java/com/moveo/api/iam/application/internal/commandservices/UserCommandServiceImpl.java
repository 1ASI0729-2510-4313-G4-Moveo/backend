package com.moveo.api.iam.application.internal.commandservices;

import com.moveo.api.iam.domain.model.aggregate.User;
import com.moveo.api.iam.domain.model.commands.CreateUserCommand;
import com.moveo.api.iam.domain.services.UserCommandService;
import com.moveo.api.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCommandServiceImpl implements UserCommandService {


    private final UserRepository userRepository;

    public UserCommandServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> handle(CreateUserCommand command) {
        if(userRepository.existsByUsernameAndEmailAndPasswordAndTypeAndPhoneNumber(command.username(),command.email(),command.password(),command.type(),command.phoneNumber()))
        {
            throw new IllegalArgumentException("User already exists with same email and password already exist");
        }

        var user = new User(command);
        var createdUser = userRepository.save(user);
        return Optional.of(createdUser);
    }
}
