package com.moveo.api.cars.application.internal.queryservices;

import com.moveo.api.cars.domain.model.aggregate.Cars;
import com.moveo.api.cars.domain.model.queries.GetAllCarsQuery;
import com.moveo.api.cars.domain.model.queries.GetAvailableCarsQuery;
import com.moveo.api.cars.domain.model.queries.GetCarsByIdQuery;
import com.moveo.api.cars.domain.services.CarQueryService;
import com.moveo.api.cars.infrastructure.persistence.jpa.repositories.CarsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarQueryServiceImpl implements CarQueryService {

    private final CarsRepository carsRepository;

    CarQueryServiceImpl(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }
    @Override
    public List<Cars> handle(GetAllCarsQuery query) {
        return this.carsRepository.findAll();
    }

    @Override
    public List<Cars> handle(GetAvailableCarsQuery query) {
        return this.carsRepository.findByAvailableTrue();
    }

    @Override
    public Optional<Cars> handle(GetCarsByIdQuery query) {
        return this.carsRepository.findById(query.id());
    }
}
