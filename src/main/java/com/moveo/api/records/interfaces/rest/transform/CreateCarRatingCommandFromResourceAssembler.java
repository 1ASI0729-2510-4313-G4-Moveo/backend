package com.moveo.api.records.interfaces.rest.transform;

import com.moveo.api.records.domain.model.commands.CreateCarRatingCommand;
import com.moveo.api.records.interfaces.rest.resources.CreateCarRatingResource;

public class CreateCarRatingCommandFromResourceAssembler {

    public static CreateCarRatingCommand toCommandFromResource(CreateCarRatingResource resource) {
        return new CreateCarRatingCommand(resource.userId(), resource.carId(), resource.rentalId(), resource.rating());
    }
}
