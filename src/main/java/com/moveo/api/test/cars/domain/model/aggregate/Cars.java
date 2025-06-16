package com.moveo.api.test.cars.domain.model.aggregate;

import com.moveo.api.test.cars.domain.model.commands.CreateCarCommand;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Getter
public class Cars {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String condition;

    @Column(nullable = false)
    private String available;

    @Column(nullable = false)
    private Long carsStationsId;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

    protected Cars() {
    }

    public Cars(CreateCarCommand command) {
        this.available = command.available();
        this.condition = command.condition();
    }
}
