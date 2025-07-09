package com.moveo.api.iam.interfaces.rest.transform;

import com.moveo.api.iam.domain.model.commands.SignUpCommand;
import com.moveo.api.iam.domain.model.entities.Role;
import com.moveo.api.iam.interfaces.rest.resources.SignUpResource;

import java.util.ArrayList;

public class SignUpCommandFromResourceAssembler {
    public static SignUpCommand toCommandFromResource(SignUpResource resource) {
        var roles = resource.roles() != null ? resource.roles().stream().map(name -> Role.toRoleFromName(name)).toList() : new ArrayList<Role>();
        return new SignUpCommand(resource.email(), resource.password(), resource.name(), resource.phone(), roles);
    }
}
