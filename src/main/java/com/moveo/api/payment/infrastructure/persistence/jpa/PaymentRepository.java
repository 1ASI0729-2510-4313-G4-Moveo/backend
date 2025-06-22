package com.moveo.api.payment.infrastructure.persistence.jpa;

import com.moveo.api.payment.domain.model.aggregate.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    boolean existsByAmount(Float amount);

    List<Payment> Id(Long id);

    List<Payment> findByAmount(Float amount);

}
