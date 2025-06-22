package com.moveo.api.iam.domain.model.commands;

public record CreateUserCommand(String username, String email, String password, String type, String phoneNumber) {
    public CreateUserCommand {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("Type cannot be null or empty");
        }
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be null or empty");
        }
    }
}
