package com.moveo.api.providers.interfaces.rest.transform;

import com.moveo.api.providers.interfaces.rest.resources.ProviderReservationResource;
import com.moveo.api.rents.domain.model.aggregate.Rent;

public class ProviderReservationResourceFromEntityAssembler {
    public static ProviderReservationResource toResourceFromEntity(Rent entity) {
        return new ProviderReservationResource(
                entity.getId(),
                entity.getStarTime(),
                entity.getEndTime(),
                entity.getPaymentId(),
                entity.getUserId(),
                entity.getCarsStationsId(),
                determineStatus(entity)
        );
    }
    
    private static String determineStatus(Rent rent) {
        // Lógica simple para determinar el estado basado en las fechas
        var now = new java.util.Date();
        if (rent.getEndTime().before(now)) {
            return "COMPLETED";
        } else if (rent.getStarTime().before(now)) {
            return "ACTIVE";
        } else {
            return "PENDING";
        }
    }
}
