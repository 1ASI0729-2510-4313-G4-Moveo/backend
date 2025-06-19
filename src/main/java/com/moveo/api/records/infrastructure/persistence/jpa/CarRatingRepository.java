package com.moveo.api.records.infrastructure.persistence.jpa;

import com.moveo.api.records.domain.model.aggregate.CarRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRatingRepository extends JpaRepository<CarRating, Long> {
    
    boolean existsByUserIdAndRentalId(Long userId, Long rentalId);
    
    Optional<CarRating> findByUserIdAndRentalId(Long userId, Long rentalId);
    
    List<CarRating> findByCarId(Long carId);
}
