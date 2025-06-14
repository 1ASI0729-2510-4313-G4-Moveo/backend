package com.moveo.api.test.cars.domain.services;

import com.moveo.api.test.cars.domain.model.aggregate.Cars;
import com.moveo.api.test.cars.domain.model.queries.GetAllCarsQuery;
import com.moveo.api.test.cars.domain.model.queries.GetAvailableCarsQuery;
import com.moveo.api.test.cars.domain.model.queries.GetCarsByIdQuery;

import java.util.List;
import java.util.Optional;

public interface CarQueryService {
    List<Cars> handle(GetAllCarsQuery query);
    List<Cars> handle(GetAvailableCarsQuery query);
    Optional<Cars> handle(GetCarsByIdQuery query);

}
