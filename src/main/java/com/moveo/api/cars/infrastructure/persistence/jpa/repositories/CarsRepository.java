package com.moveo.api.cars.infrastructure.persistence.jpa.repositories;

import com.moveo.api.cars.domain.model.aggregate.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarsRepository extends JpaRepository<Cars, Long> {

    boolean existsByAvailableAndConditions(String available, String conditions);

    List<Cars> Id(Long id);
    List<Cars> findByAvailableTrue();

}
