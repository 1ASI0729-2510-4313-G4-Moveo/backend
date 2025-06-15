package com.moveo.api.test.records.domain.services;

import com.moveo.api.test.records.domain.model.aggregate.CarRating;
import com.moveo.api.test.records.domain.model.queries.GetAverageRatingByCarIdQuery;
import com.moveo.api.test.records.domain.model.queries.GetCarRatingByUserAndRentalQuery;
import com.moveo.api.test.records.domain.model.queries.GetCarRatingsByCarIdQuery;

import java.util.List;
import java.util.Optional;

public interface CarRatingQueryService {
    List<CarRating> handle(GetCarRatingsByCarIdQuery query);
    Optional<CarRating> handle(GetCarRatingByUserAndRentalQuery query);
    Double handle(GetAverageRatingByCarIdQuery query);
}
