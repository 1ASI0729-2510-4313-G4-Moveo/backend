package com.moveo.api.cars.application.internal.commandservices;

import com.moveo.api.cars.domain.model.aggregate.CarStation;
import com.moveo.api.cars.domain.model.commands.CreateCarStationCommand;
import com.moveo.api.cars.domain.services.CarStationCommandService;
import com.moveo.api.cars.infrastructure.persistence.jpa.repositories.CarStationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarStationCommandServiceImpl implements CarStationCommandService {

    private final CarStationRepository carStationRepository;

    public CarStationCommandServiceImpl(CarStationRepository carStationRepository) {
        this.carStationRepository = carStationRepository;
    }

    @Override
    public Optional<CarStation> handle(CreateCarStationCommand command) {
        if (carStationRepository.existsByCarIdAndStationId(command.carId(), command.stationId())) {
            throw new IllegalArgumentException("Car Station already exists with same atributes");
        }

        var carStation = new CarStation(command);
        var CreatedCarStation = carStationRepository.save(carStation);

        return Optional.of(CreatedCarStation);
    }
}
