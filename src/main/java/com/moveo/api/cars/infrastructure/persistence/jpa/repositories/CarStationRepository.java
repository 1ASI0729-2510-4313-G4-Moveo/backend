package com.moveo.api.cars.infrastructure.persistence.jpa.repositories;

import com.moveo.api.cars.domain.model.aggregate.CarStation;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarStationRepository extends JpaRepository<CarStation, Long> {

    boolean existsByNameAndAddressAndLatitudeAndLongitude(String name, String address, Float latitude, Float longitude);
}
