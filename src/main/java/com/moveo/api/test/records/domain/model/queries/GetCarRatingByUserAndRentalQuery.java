package com.moveo.api.test.records.domain.model.queries;

public record GetCarRatingByUserAndRentalQuery(Long userId, Long rentalId) {
    public GetCarRatingByUserAndRentalQuery {
        if (userId == null || userId <= 0) {
            throw new IllegalArgumentException("User ID cannot be null or negative");
        }
        if (rentalId == null || rentalId <= 0) {
            throw new IllegalArgumentException("Rental ID cannot be null or negative");
        }
    }
}
