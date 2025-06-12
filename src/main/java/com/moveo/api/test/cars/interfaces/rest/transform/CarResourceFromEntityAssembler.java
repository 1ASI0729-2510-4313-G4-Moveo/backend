package com.moveo.api.test.cars.interfaces.rest.transform;

import com.moveo.api.test.cars.domain.model.aggregate.Cars;
import com.moveo.api.test.cars.interfaces.rest.resources.CarResource;

public class CarResourceFromEntityAssembler {
    public static CarResource toResourceFromEntity(Cars entity) {
        return new CarResource(entity.getId(), entity.getCondition(), entity.getAvailable(), entity.getCarsStationsId());
    }
}
