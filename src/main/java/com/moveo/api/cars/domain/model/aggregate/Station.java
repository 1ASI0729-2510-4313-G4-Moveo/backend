package com.moveo.api.cars.domain.model.aggregate;

import com.moveo.api.cars.domain.model.commands.CreateStationCommand;
import com.moveo.api.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Getter
public class Station extends AuditableAbstractAggregateRoot<Station> {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Float latitude;

    @Column(nullable = false)
    private Float longitude;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

    protected Station() {};

    public Station(CreateStationCommand command) {
        this.name = command.name();
        this.address = command.address();
        this.latitude = command.latitude();
        this.longitude = command.longitude();
    }
}
