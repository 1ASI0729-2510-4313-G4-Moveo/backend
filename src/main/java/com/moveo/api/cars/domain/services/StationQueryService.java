package com.moveo.api.cars.domain.services;

import com.moveo.api.cars.domain.model.aggregate.Station;
import java.util.List;
import java.util.Optional;

public interface StationQueryService {
    Optional<Station> getById(Long id);
    List<Station> getAll();
} 