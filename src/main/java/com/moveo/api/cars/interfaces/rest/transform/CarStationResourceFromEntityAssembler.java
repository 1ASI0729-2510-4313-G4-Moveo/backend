package com.moveo.api.cars.interfaces.rest.transform;

import com.moveo.api.cars.domain.model.aggregate.CarStation;
import com.moveo.api.cars.interfaces.rest.resources.CarStationResource;

public class CarStationResourceFromEntityAssembler {
    public static CarStationResource toResourcesFromEntity(CarStation entity) {
        return new CarStationResource(entity.getId(),  entity.getCarId(), entity.getStationId());
    }
}
