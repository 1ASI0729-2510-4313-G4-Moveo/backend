package com.moveo.api.test.cars.interfaces.rest.transform;

import com.moveo.api.test.cars.domain.model.commands.CreateCarCommand;
import com.moveo.api.test.cars.interfaces.rest.resources.CreateCarResource;

public class CreateCarCommandFromResourceAssembler {

    public static CreateCarCommand toCommandFromResource(CreateCarResource resource) {
        return new CreateCarCommand(resource.condition(), resource.available());
    }
}
