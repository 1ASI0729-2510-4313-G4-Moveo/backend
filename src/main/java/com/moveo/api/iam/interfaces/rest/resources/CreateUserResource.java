package com.moveo.api.iam.interfaces.rest.resources;

public record CreateUserResource(String username, String password, String email, String type, String name, String phoneNumber, String identification) {
}
