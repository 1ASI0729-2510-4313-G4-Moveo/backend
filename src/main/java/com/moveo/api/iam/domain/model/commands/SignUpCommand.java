package com.moveo.api.iam.domain.model.commands;

import com.moveo.api.iam.domain.model.aggregates.User;
import com.moveo.api.iam.domain.model.entities.Type;

import java.util.List;

/**
 * Sign up command
 * <p>
 *     This class represents the command to sign up a user.
 * </p>
 * @param email the email of the user
 * @param password the password of the user
 * @param name the name of the user
 * @param phone the phone of the user
 * @param types the types of the user
 *
 * @see User
 */
public record SignUpCommand(String email, String password, String name, String phone, List<Type> types) {
}
