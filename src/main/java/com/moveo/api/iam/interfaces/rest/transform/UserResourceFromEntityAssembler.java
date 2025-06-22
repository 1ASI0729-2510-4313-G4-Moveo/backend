package com.moveo.api.iam.interfaces.rest.transform;

import com.moveo.api.iam.domain.model.aggregate.User;
import com.moveo.api.iam.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User entity) {
        return new UserResource(entity.getId(), entity.getUsername(), entity.getEmail(), entity.getPassword(), entity.getType(), entity.getPhoneNumber());
    }
}
