package com.moveo.api.cars.domain.model.aggregate;

import com.moveo.api.cars.domain.model.commands.CreateCarStationCommand;
import com.moveo.api.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class CarStation extends AuditableAbstractAggregateRoot<CarStation> {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Float latitude;

    @Column(nullable = false)
    private Float longitude;

    protected CarStation() {};

    public CarStation(CreateCarStationCommand command) {
        this.name = command.name();
        this.address = command.address();
        this.latitude = command.latitude();
        this.longitude = command.longitude();
    }

}
