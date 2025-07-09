package com.moveo.api.cars.infrastructure.persistence.jpa.repositories;

import com.moveo.api.cars.domain.model.aggregate.CarStation;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarStationRepository extends JpaRepository<CarStation, Long> {

    boolean existsByCarIdAndStationId(Long carId, Long stationId);

    List<CarStation> findByCarId(Long carId);

}
