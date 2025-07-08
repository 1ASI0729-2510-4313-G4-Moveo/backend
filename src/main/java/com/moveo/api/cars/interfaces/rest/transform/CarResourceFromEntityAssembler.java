package com.moveo.api.cars.interfaces.rest.transform;

import com.moveo.api.cars.domain.model.aggregate.Cars;
import com.moveo.api.cars.interfaces.rest.resources.CarResource;

public class CarResourceFromEntityAssembler {
    public static CarResource toResourceFromEntity(Cars entity) {
        return new CarResource(entity.getId(), entity.getConditions(), entity.getAvailable(), entity.getCarsStationsId());
    }
}
