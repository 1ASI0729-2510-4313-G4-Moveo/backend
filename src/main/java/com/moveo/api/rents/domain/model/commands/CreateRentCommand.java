package com.moveo.api.rents.domain.model.commands;

import java.util.Date;

public record CreateRentCommand(Date starTime, Date endTime, Long paymentId, Long userId, Long carsStationId) {

    public CreateRentCommand {
        if (starTime == null || endTime == null) {
            throw new IllegalArgumentException("Start time and End time must not be null");
        }
        if (!starTime.before(endTime)) {
            throw new IllegalArgumentException("Start time must be before End time");
        }
    }

}
