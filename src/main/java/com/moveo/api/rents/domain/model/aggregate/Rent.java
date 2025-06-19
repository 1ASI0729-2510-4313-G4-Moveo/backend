package com.moveo.api.rents.domain.model.aggregate;

import com.moveo.api.rents.domain.model.commands.CreateRentCommand;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
@Getter
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private Date starTime;

    @Column(nullable = false)
    private Date endTime;

    @Column(nullable = false)
    private Long PaymentId;

    @Column(nullable = false)
    private Long UserId;

    @Column(nullable = false)
    private Long CarsStationsId;

    protected Rent() {
    }

    public Rent(CreateRentCommand command){
        this.starTime = command.starTime();
        this.endTime = command.endTime();
        // TODO: Set PaymentId, UserId, and CarsStationsId from command when available
    }
}
