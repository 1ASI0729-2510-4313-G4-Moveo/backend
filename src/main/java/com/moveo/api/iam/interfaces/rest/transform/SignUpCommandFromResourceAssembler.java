package com.moveo.api.iam.interfaces.rest.transform;

import com.moveo.api.iam.domain.model.commands.SignUpCommand;
import com.moveo.api.iam.domain.model.entities.Type;
import com.moveo.api.iam.interfaces.rest.resources.SignUpResource;

import java.util.ArrayList;

public class SignUpCommandFromResourceAssembler {
    public static SignUpCommand toCommandFromResource(SignUpResource resource) {
        var types = resource.types() != null ? resource.types().stream().map(name -> Type.toTypeFromName(name)).toList() : new ArrayList<Type>();
        return new SignUpCommand(resource.email(), resource.password(), resource.name(), resource.phone(), types);
    }
}
