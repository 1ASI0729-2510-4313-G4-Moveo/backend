package com.moveo.api.records.domain.services;

import com.moveo.api.records.domain.model.aggregate.CarRating;
import com.moveo.api.records.domain.model.commands.CreateCarRatingCommand;

import java.util.Optional;

public interface CarRatingCommandService {
    Optional<CarRating> handle(CreateCarRatingCommand createCarRatingCommand);
}
