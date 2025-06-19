package com.moveo.api.cars.interfaces.rest.transform;

import com.moveo.api.cars.domain.model.commands.CreateCarCommand;
import com.moveo.api.cars.interfaces.rest.resources.CreateCarResource;

public class CreateCarCommandFromResourceAssembler {

    public static CreateCarCommand toCommandFromResource(CreateCarResource resource) {
        return new CreateCarCommand(resource.condition(), resource.available());
    }
}
