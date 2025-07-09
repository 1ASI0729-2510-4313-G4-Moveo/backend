package com.moveo.api.cars.application.internal.queryservices;

import com.moveo.api.cars.domain.model.aggregate.Station;
import com.moveo.api.cars.domain.services.StationQueryService;
import com.moveo.api.cars.infrastructure.persistence.jpa.repositories.StationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StationQueryServiceImpl implements StationQueryService {
    private final StationRepository stationRepository;

    public StationQueryServiceImpl(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @Override
    public Optional<Station> getById(Long id) {
        return stationRepository.findById(id);
    }

    @Override
    public List<Station> getAll() {
        return stationRepository.findAll();
    }
} 