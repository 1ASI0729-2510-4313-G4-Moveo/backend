package com.moveo.api.cars.interfaces.rest.transform;

import com.moveo.api.cars.domain.model.commands.CreateCarStationCommand;
import com.moveo.api.cars.interfaces.rest.resources.CreateCarStationResource;

public class CreateCarStationCommandFromResourceAssembler {

    public static CreateCarStationCommand toCommandFromResource(CreateCarStationResource resource) {
        return new CreateCarStationCommand(resource.name(), resource.address(), resource.latitude(), resource.longitude());
    }
}
