package com.moveo.api.cars.interfaces.rest.transform;

import com.moveo.api.cars.domain.model.aggregate.Station;
import com.moveo.api.cars.interfaces.rest.resources.StationResource;

public class StationResourceFromEntityAssembler {
    public static StationResource toResourceFromEntity(Station station) {
        return new StationResource(
            station.getId(),
            station.getName(),
            station.getAddress(),
            station.getLatitude(),
            station.getLongitude()
        );
    }
} 