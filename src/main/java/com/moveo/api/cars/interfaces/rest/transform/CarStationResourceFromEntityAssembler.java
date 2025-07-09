package com.moveo.api.cars.interfaces.rest.transform;

import com.moveo.api.cars.domain.model.aggregate.CarStation;
import com.moveo.api.cars.interfaces.rest.resources.CarStationResource;
import com.moveo.api.cars.interfaces.rest.resources.CarResource;
import com.moveo.api.cars.interfaces.rest.resources.StationResource;

public class CarStationResourceFromEntityAssembler {
    public static CarStationResource toResourceFromEntity(CarStation entity, CarResource car, StationResource station) {
        return new CarStationResource(entity.getId(), car, station);
    }
}
