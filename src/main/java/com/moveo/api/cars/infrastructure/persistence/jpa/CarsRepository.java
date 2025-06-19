package com.moveo.api.cars.infrastructure.persistence.jpa;

import com.moveo.api.cars.domain.model.aggregate.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarsRepository extends JpaRepository<Cars, Long> {

    boolean existsByAvailableAndCondition(String available, String condition);

    List<Cars> Id(Long id);
    List<Cars> findByAvailableTrue();

    List<Cars> findByCarsStationsId(Long carsStationsId);

}
