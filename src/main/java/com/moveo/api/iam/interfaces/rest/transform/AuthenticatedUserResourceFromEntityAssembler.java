package com.moveo.api.iam.interfaces.rest.transform;

import com.moveo.api.iam.domain.model.aggregates.User;
import com.moveo.api.iam.interfaces.rest.resources.AuthenticatedUserResource;

public class AuthenticatedUserResourceFromEntityAssembler {
    public static AuthenticatedUserResource toResourceFromEntity(User user, String token) {
        return new AuthenticatedUserResource(user.getId(), user.getEmail(), token);
    }
}
