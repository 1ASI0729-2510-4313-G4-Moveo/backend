package com.moveo.api.records.application.internal.queryservices;

import com.moveo.api.records.domain.model.aggregate.CarRating;
import com.moveo.api.records.domain.model.queries.GetAverageRatingByCarIdQuery;
import com.moveo.api.records.domain.model.queries.GetCarRatingByUserAndRentalQuery;
import com.moveo.api.records.domain.model.queries.GetCarRatingsByCarIdQuery;
import com.moveo.api.records.domain.services.CarRatingQueryService;
import com.moveo.api.records.infrastructure.persistence.jpa.CarRatingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarRatingQueryServiceImpl implements CarRatingQueryService {

    private final CarRatingRepository carRatingRepository;

    public CarRatingQueryServiceImpl(CarRatingRepository carRatingRepository) {
        this.carRatingRepository = carRatingRepository;
    }

    @Override
    public List<CarRating> handle(GetCarRatingsByCarIdQuery query) {
        return carRatingRepository.findByCarId(query.carId());
    }

    @Override
    public Optional<CarRating> handle(GetCarRatingByUserAndRentalQuery query) {
        return carRatingRepository.findByUserIdAndRentalId(query.userId(), query.rentalId());
    }

    @Override
    public Double handle(GetAverageRatingByCarIdQuery query) {
        List<CarRating> ratings = carRatingRepository.findByCarId(query.carId());
        if (ratings.isEmpty()) {
            return 0.0;
        }
        
        double average = ratings.stream()
                .mapToInt(CarRating::getRating)
                .average()
                .orElse(0.0);
        
        return Math.round(average * 100.0) / 100.0; // Redondear a 2 decimales
    }
}
