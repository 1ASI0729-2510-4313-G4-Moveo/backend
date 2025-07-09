package com.moveo.api.rents.interfaces.rest.transform;

import com.moveo.api.rents.domain.model.commands.CreateRentCommand;
import com.moveo.api.rents.interfaces.rest.resources.CreateRentResource;

public class CreateRentCommandFromResourceAssembler {
    public static CreateRentCommand toCommandFromResource(CreateRentResource resource) {
        return new CreateRentCommand(
            resource.starTime(),
            resource.endTime(),
            resource.paymentId(),
            resource.userId(),
            resource.carsStationId()
        );
    }
}
