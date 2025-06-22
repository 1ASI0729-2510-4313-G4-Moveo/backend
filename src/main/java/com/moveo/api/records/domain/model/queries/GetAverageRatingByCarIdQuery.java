package com.moveo.api.records.domain.model.queries;

public record GetAverageRatingByCarIdQuery(Long carId) {
    public GetAverageRatingByCarIdQuery {
        if (carId == null || carId <= 0) {
            throw new IllegalArgumentException("Car ID cannot be null or negative");
        }
    }
}
