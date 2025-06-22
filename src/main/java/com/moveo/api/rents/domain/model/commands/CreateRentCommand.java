package com.moveo.api.rents.domain.model.commands;

import java.util.Date;

public record CreateRentCommand(Date starTime, Date endTime ) {

    public CreateRentCommand {
        if (starTime.before(endTime)) {
            throw new IllegalArgumentException("Start time must be after End time");
        }
        if (endTime.after(starTime)) {
            throw new IllegalArgumentException("End time must be before Star time");
        }
    }

}
