package com.moveo.api.rents.interfaces.rest.resources;

import java.util.Date;

public record RentResource(Long id, Date starTime, Date endTime, Long paymentId, Long userId, Long carsStationId) {

}
