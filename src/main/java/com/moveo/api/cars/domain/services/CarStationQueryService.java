package com.moveo.api.cars.domain.services;

import com.moveo.api.cars.domain.model.aggregate.CarStation;
import com.moveo.api.cars.domain.model.queries.GetAllCarStationsQuery;
import com.moveo.api.cars.domain.model.queries.GetCarStationByIdQuery;

import java.util.List;
import java.util.Optional;

public interface CarStationQueryService {
    List<CarStation> handle(GetAllCarStationsQuery query);
    Optional<CarStation> handle(GetCarStationByIdQuery query);
}
