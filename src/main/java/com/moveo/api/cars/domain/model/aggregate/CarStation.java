package com.moveo.api.cars.domain.model.aggregate;

import com.moveo.api.cars.domain.model.commands.CreateCarStationCommand;
import com.moveo.api.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class CarStation extends AuditableAbstractAggregateRoot<CarStation> {

    @Column(nullable = false)
    private Long stationId;

    @Column(nullable = false)
    private Long carId;

    protected CarStation() {};

    public CarStation(CreateCarStationCommand command) {
        this.carId = command.carId();
        this.stationId = command.stationId();
    }
}
