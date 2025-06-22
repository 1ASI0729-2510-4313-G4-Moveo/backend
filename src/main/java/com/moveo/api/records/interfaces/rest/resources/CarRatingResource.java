package com.moveo.api.records.interfaces.rest.resources;

import java.time.LocalDateTime;

public record CarRatingResource(Long id, Long userId, Long carId, Long rentalId, Integer rating, LocalDateTime ratingDate) {
}
