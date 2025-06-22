package com.moveo.api.iam.domain.model.aggregate;

import com.moveo.api.cars.domain.model.commands.CreateCarCommand;
import com.moveo.api.iam.domain.model.commands.CreateUserCommand;
import com.moveo.api.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
@Getter
public class User extends AuditableAbstractAggregateRoot<User> {

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String phoneNumber;

    protected User() {
    }

    public User(CreateUserCommand command) {
        this.username = command.username();
        this.email = command.email();
        this.password = command.password();
        this.type = command.type();
        this.phoneNumber = command.phoneNumber();
    }
}
