package com.moveo.api.iam.interfaces.rest.resources;

public record AuthenticatedUserResource(Long id, String email, String token) {

}
