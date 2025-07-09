package com.moveo.api.cars.domain.model.commands;

public record CreateCarCommand(String conditions, String available) {

    public CreateCarCommand {
        if (available == null || available.isEmpty()) {
            throw new IllegalArgumentException("Available cannot be null or empty");
        }
        if (conditions == null || conditions.isEmpty()) {
            throw new IllegalArgumentException("Condition cannot be null or empty");
        }
    }
}
