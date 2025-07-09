package com.moveo.api.cars.infrastructure.persistence.jpa.repositories;

import com.moveo.api.cars.domain.model.aggregate.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station, Long> {

    boolean existsByLatitudeAndLongitude( Float latitude, Float longitude);
    Station findByLatitudeAndLongitude(Float latitude, Float longitude);

}
