package com.moveo.api.iam.interfaces.rest.transform;

import com.moveo.api.iam.domain.model.commands.CreateUserCommand;
import com.moveo.api.iam.interfaces.rest.resources.CreateUserResource;

public class CreateUserCommandFromResourceAssembler {

    public static CreateUserCommand toCommandFromResource(CreateUserResource resource) {
        return new CreateUserCommand(resource.username(), resource.email(), resource.password(), resource.type(),  resource.phoneNumber());
    }
}
