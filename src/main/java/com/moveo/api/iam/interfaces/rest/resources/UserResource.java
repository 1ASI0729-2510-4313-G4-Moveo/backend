package com.moveo.api.iam.interfaces.rest.resources;

public record UserResource(Long id, String username, String password, String email, String type, String phoneNumber ) {
}
