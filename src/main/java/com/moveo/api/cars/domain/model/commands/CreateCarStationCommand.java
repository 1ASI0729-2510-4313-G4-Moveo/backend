package com.moveo.api.cars.domain.model.commands;

public record CreateCarStationCommand(String name, String address, Float latitude, Float longitude) {
    public CreateCarStationCommand {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name is required");
        }
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Address is required");
        }
        if (latitude == null || latitude <= 0 ) {
            throw new IllegalArgumentException("Latitude is required");
        }
        if (longitude == null || longitude <= 0) {
            throw new IllegalArgumentException("Longitude is required");
        }
    }
}
