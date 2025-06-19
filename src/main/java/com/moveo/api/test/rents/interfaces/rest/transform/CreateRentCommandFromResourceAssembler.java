package com.moveo.api.test.rents.interfaces.rest.transform;

import com.moveo.api.test.rents.domain.model.commands.CreateRentCommand;

public class CreateRentCommandFromResourceAssembler {
    public static CreateRentCommand toCommandFromResource(CreateRentCommand resource) {
        return new CreateRentCommand(resource.starTime(), resource.endTime());
    }
}
