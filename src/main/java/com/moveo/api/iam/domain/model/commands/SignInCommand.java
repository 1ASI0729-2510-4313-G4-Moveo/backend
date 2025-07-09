package com.moveo.api.iam.domain.model.commands;

import com.moveo.api.iam.domain.model.aggregates.User;

/**
 * Sign in command
 * <p>
 *     This class represents the command to sign in a user.
 * </p>
 * @param email the email of the user
 * @param password the password of the user
 *
 * @see User
 */
public record SignInCommand(String email, String password) {
}
