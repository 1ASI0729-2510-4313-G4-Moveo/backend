package com.moveo.api.test.cars.application.internal.commandservices;

import com.moveo.api.test.cars.domain.model.aggregate.Cars;
import com.moveo.api.test.cars.domain.model.commands.CreateCarCommand;
import com.moveo.api.test.cars.domain.services.CarCommandService;
import com.moveo.api.test.cars.infrastructure.persistence.jpa.CarsRepository;
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
        if (carsRepository.existsByAvailableAndCondition(command.available(), command.condition())) {
            throw new IllegalArgumentException("Car already exists with same condition and available register");
        }
        var cars = new Cars(command);
        var createdCars = carsRepository.save(cars);

        return Optional.of(createdCars);
    }
}
