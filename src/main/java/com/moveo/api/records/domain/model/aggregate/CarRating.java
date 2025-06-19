package com.moveo.api.records.domain.model.aggregate;

import com.moveo.api.records.domain.model.commands.CreateCarRatingCommand;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
public class CarRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long carId;

    @Column(nullable = false)
    private Long rentalId;

    @Column(nullable = false)
    private Integer rating;

    @Column(nullable = false)
    private LocalDateTime ratingDate;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

    protected CarRating() {
    }

    public CarRating(CreateCarRatingCommand command) {
        this.userId = command.userId();
        this.carId = command.carId();
        this.rentalId = command.rentalId();
        this.rating = command.rating();
        this.ratingDate = LocalDateTime.now();
    }
}
