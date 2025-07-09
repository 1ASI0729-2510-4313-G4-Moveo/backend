package com.moveo.api.cars.domain.model.commands;

public record CreateCarStationCommand(Long carId, Long stationId) {
    public CreateCarStationCommand {
        if (carId == null) {
            throw new IllegalArgumentException("CarId is required");
        }
        if (stationId == null) {
            throw new IllegalArgumentException("StationId is required");
        }
    }
}
