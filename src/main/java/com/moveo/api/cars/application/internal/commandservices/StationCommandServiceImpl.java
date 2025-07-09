package com.moveo.api.cars.application.internal.commandservices;

import com.moveo.api.cars.domain.model.aggregate.Station;
import com.moveo.api.cars.domain.model.commands.CreateStationCommand;
import com.moveo.api.cars.domain.services.StationCommandService;
import com.moveo.api.cars.infrastructure.persistence.jpa.repositories.StationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StationCommandServiceImpl implements StationCommandService {

    private final StationRepository stationRepository;

    public StationCommandServiceImpl(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @Override
    public Optional<Station> handle(CreateStationCommand command) {
        if (stationRepository.existsByLatitudeAndLongitude(command.latitude(), command.longitude())) {
            throw new IllegalArgumentException("Station already exists with same atributes");
        }

        var station = new Station(command);
        var CreatedStation = stationRepository.save(station);

        return Optional.of(CreatedStation);
    }
}
