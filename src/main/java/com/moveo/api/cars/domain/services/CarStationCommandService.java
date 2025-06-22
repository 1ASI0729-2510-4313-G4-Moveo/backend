package com.moveo.api.cars.domain.services;

import com.moveo.api.cars.domain.model.aggregate.CarStation;
import com.moveo.api.cars.domain.model.commands.CreateCarStationCommand;

import java.util.Optional;

public interface CarStationCommandService {
    Optional<CarStation> handle(CreateCarStationCommand createCarStationCommand);
}
