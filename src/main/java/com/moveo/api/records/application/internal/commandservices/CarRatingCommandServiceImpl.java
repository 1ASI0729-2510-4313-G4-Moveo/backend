package com.moveo.api.records.application.internal.commandservices;

import com.moveo.api.records.domain.model.aggregate.CarRating;
import com.moveo.api.records.domain.model.commands.CreateCarRatingCommand;
import com.moveo.api.records.domain.services.CarRatingCommandService;
import com.moveo.api.records.infrastructure.persistence.jpa.CarRatingRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarRatingCommandServiceImpl implements CarRatingCommandService {

    private final CarRatingRepository carRatingRepository;

    public CarRatingCommandServiceImpl(CarRatingRepository carRatingRepository) {
        this.carRatingRepository = carRatingRepository;
    }

    @Override
    public Optional<CarRating> handle(CreateCarRatingCommand command) {
        // Verificar que no existe una calificación duplicada
        if (carRatingRepository.existsByUserIdAndRentalId(command.userId(), command.rentalId())) {
            throw new IllegalArgumentException("Rating already exists for this user and rental");
        }

        var carRating = new CarRating(command);
        var createdCarRating = carRatingRepository.save(carRating);

        return Optional.of(createdCarRating);
    }
}
