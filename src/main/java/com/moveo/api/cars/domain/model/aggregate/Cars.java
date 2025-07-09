package com.moveo.api.cars.domain.model.aggregate;

import com.moveo.api.cars.domain.model.commands.CreateCarCommand;
import com.moveo.api.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Getter
public class Cars extends AuditableAbstractAggregateRoot<Cars> {

    @Column(nullable = false)
    private String conditions;

    @Column(nullable = false)
    private String available;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

    protected Cars() {
    }

    public Cars(CreateCarCommand command) {
        this.available = command.available();
        this.conditions = command.conditions();
    }
}
