package com.moveo.api.rents.infrastructure.persistence.jpa;

import com.moveo.api.rents.domain.model.aggregate.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface RentsRepository extends JpaRepository<Rent, Long> {
    boolean existsByStarTimeAndEndTime(Date starTime, Date endTime);

    List<Rent> Id(Long id);
}
