package com.moveo.api.cars.interfaces.rest.transform;

import com.moveo.api.cars.domain.model.commands.CreateStationCommand;
import com.moveo.api.cars.interfaces.rest.resources.CreateStationResource;

public class CreateStationCommandFromResourceAssembler {
    public static CreateStationCommand toCommandFromResource(CreateStationResource resource) {
        return new CreateStationCommand(resource.name(), resource.address(), resource.latitude(), resource.longitude());
    }
} 