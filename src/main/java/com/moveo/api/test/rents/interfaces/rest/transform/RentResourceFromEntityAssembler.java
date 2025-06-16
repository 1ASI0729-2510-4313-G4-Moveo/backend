package com.moveo.api.test.rents.interfaces.rest.transform;

import com.moveo.api.test.rents.domain.model.aggregate.Rent;
import com.moveo.api.test.rents.interfaces.rest.resources.RentResource;

public class RentResourceFromEntityAssembler {
    public static RentResource toResourceFromEntity(Rent entity) {
        return new RentResource(entity.getId(), entity.getStarTime(), entity.getEndTime(), entity.getPaymentId(), entity.getUserId(), entity.getCarsStationsId());
    }
}
