package com.moveo.api.records.interfaces.rest.resources;

import com.moveo.api.iam.interfaces.rest.resources.UserResource;
import com.moveo.api.cars.interfaces.rest.resources.CarResource;
import com.moveo.api.rents.interfaces.rest.resources.RentResource;
import java.time.LocalDateTime;

public record CarRatingResource(Long id, UserResource user, CarResource car, RentResource rent, Integer rating, LocalDateTime ratingDate) {
}
