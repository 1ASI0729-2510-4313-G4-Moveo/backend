package com.moveo.api.cars.application.internal.queryservices;

import com.moveo.api.cars.domain.model.aggregate.CarStation;
import com.moveo.api.cars.domain.model.queries.GetAllCarStationByCarIdQuery;
import com.moveo.api.cars.domain.model.queries.GetAllCarStationsQuery;
import com.moveo.api.cars.domain.model.queries.GetCarStationByIdQuery;
import com.moveo.api.cars.domain.services.CarStationQueryService;
import com.moveo.api.cars.infrastructure.persistence.jpa.repositories.CarStationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarStationQueryServiceImpl implements CarStationQueryService {

    private final CarStationRepository carStationRepository;

    public CarStationQueryServiceImpl(CarStationRepository carStationRepository) {
        this.carStationRepository = carStationRepository;
    }

    @Override
    public List<CarStation> handle(GetAllCarStationsQuery query) {
        return this.carStationRepository.findAll();
    }

    @Override
    public Optional<CarStation> handle(GetCarStationByIdQuery query) {
        return this.carStationRepository.findById(query.id());
    }

    @Override
    public List<CarStation> handle(GetAllCarStationByCarIdQuery query) {
        return this.carStationRepository.findByCarId(query.carId());
    }
}
