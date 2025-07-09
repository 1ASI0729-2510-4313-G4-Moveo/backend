package com.moveo.api.cars.application.internal.commandservices;

import com.moveo.api.cars.domain.model.aggregate.Cars;
import com.moveo.api.cars.domain.model.commands.CreateCarCommand;
import com.moveo.api.cars.domain.services.CarCommandService;
import com.moveo.api.cars.infrastructure.persistence.jpa.repositories.CarsRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarCommandServiceImpl implements CarCommandService {

    private final CarsRepository carsRepository;

    public CarCommandServiceImpl(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    @Override
    public Optional<Cars> handle(CreateCarCommand command) {
        if (carsRepository.existsByAvailableAndConditions(command.available(), command.conditions())) {
            throw new IllegalArgumentException("Car already exists with same condition and available register");
        }
        var cars = new Cars(command);
        var createdCars = carsRepository.save(cars);

        return Optional.of(createdCars);
    }
}
