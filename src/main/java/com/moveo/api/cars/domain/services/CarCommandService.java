package com.moveo.api.cars.domain.services;

import com.moveo.api.cars.domain.model.aggregate.Cars;
import com.moveo.api.cars.domain.model.commands.CreateCarCommand;

import java.util.Optional;

public interface CarCommandService {

    Optional<Cars> handle(CreateCarCommand createCarCommand);
}
