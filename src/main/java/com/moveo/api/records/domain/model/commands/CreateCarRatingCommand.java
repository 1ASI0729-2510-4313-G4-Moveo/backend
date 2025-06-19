package com.moveo.api.records.domain.model.commands;

public record CreateCarRatingCommand(Long userId, Long carId, Long rentalId, Integer rating) {

    public CreateCarRatingCommand {
        if (userId == null || userId <= 0) {
            throw new IllegalArgumentException("User ID cannot be null or negative");
        }
        if (carId == null || carId <= 0) {
            throw new IllegalArgumentException("Car ID cannot be null or negative");
        }
        if (rentalId == null || rentalId <= 0) {
            throw new IllegalArgumentException("Rental ID cannot be null or negative");
        }
        if (rating == null || rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
    }
}
