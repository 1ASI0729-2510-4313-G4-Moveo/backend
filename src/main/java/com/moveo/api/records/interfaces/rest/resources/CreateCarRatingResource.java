package com.moveo.api.records.interfaces.rest.resources;

public record CreateCarRatingResource(Long userId, Long carId, Long rentalId, Integer rating) {
}
