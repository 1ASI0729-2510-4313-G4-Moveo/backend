package com.moveo.api.test.cars.application;

import com.moveo.api.test.cars.domain.model.aggregate.Cars;
import com.moveo.api.test.cars.infrastructure.persistence.jpa.CarsRepository;

import java.util.List;
import java.util.Optional;

public class DemoUsageRepoService {
    private final CarsRepository carsRepository;

    public DemoUsageRepoService(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    public List<Cars> getAll() {
        return carsRepository.findAll();
    }
    public Optional<Cars> getById(Long id) {
        return carsRepository.findById(id);
    }
}
