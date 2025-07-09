package com.moveo.api.iam.interfaces.rest.transform;

import com.moveo.api.iam.domain.model.commands.SignInCommand;
import com.moveo.api.iam.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {
    public static SignInCommand toCommandFromResource(SignInResource signInResource) {
        return new SignInCommand(signInResource.email(), signInResource.password());
    }
}
