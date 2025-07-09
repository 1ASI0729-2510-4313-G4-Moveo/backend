package com.moveo.api.iam.interfaces.rest.transform;

import com.moveo.api.iam.domain.model.aggregates.User;
import com.moveo.api.iam.domain.model.entities.Type;
import com.moveo.api.iam.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User user) {
        var types = user.getTypes().stream().map(Type::getStringName).toList();
        return new UserResource(user.getId(), user.getEmail(), user.getPassword(), user.getName(), user.getPhone(), types);
    }
}
