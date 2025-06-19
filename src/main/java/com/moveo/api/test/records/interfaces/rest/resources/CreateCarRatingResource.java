package com.moveo.api.test.records.interfaces.rest.resources;

public record CreateCarRatingResource(Long userId, Long carId, Long rentalId, Integer rating) {
}
