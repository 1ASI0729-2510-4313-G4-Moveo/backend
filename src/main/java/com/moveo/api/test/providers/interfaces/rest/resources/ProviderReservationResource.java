package com.moveo.api.test.providers.interfaces.rest.resources;

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
