package com.moveo.api.records.interfaces.rest.transform;

import com.moveo.api.records.domain.model.aggregate.CarRating;
import com.moveo.api.records.interfaces.rest.resources.CarRatingResource;

public class CarRatingResourceFromEntityAssembler {
    public static CarRatingResource toResourceFromEntity(CarRating entity) {
        return new CarRatingResource(
                entity.getId(),
                entity.getUserId(),
                entity.getCarId(),
                entity.getRentalId(),
                entity.getRating(),
                entity.getRatingDate()
        );
    }
}
