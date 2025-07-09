package com.moveo.api.cars.domain.services;

import com.moveo.api.cars.domain.model.aggregate.Station;
import com.moveo.api.cars.domain.model.commands.CreateStationCommand;

import java.util.Optional;

public interface StationCommandService {
    Optional<Station> handle(CreateStationCommand createStationCommand);
}
