package com.moveo.api.providers.interfaces.rest.resources;

import java.util.Date;

public record ProviderReservationResource(
        Long id,
        Date startTime,
        Date endTime,
        Long paymentId,
        Long userId,
        Long carsStationsId,
        String status
) {
}
