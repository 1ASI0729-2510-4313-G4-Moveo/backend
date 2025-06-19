package com.moveo.api.test.records.domain.model.queries;

public record GetCarRatingsByCarIdQuery(Long carId) {
    public GetCarRatingsByCarIdQuery {
        if (carId == null || carId <= 0) {
            throw new IllegalArgumentException("Car ID cannot be null or negative");
        }
    }
}
