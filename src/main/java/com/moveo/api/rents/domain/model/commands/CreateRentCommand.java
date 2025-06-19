package com.moveo.api.rents.domain.model.commands;

import java.util.Date;

public record CreateRentCommand(Date starTime, Date endTime ) {

    public CreateRentCommand {
        if (starTime == null) {
            throw new IllegalArgumentException("Start time cannot be null");
        }
        if (endTime == null) {
            throw new IllegalArgumentException("End time cannot be null");
        }
        if (starTime.after(endTime)) {
            throw new IllegalArgumentException("Start time must be before End time");
        }
    }

}
