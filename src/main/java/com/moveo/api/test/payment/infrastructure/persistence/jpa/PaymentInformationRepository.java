package com.moveo.api.test.payment.infrastructure.persistence.jpa;

import com.moveo.api.test.payment.domain.model.aggregate.PaymentInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentInformationRepository extends JpaRepository<PaymentInformation, Long> {
    boolean existsByHolderAndCardNumber(String holder, Long cardNumber);

    List<PaymentInformation> Id(Long id);

    Optional<PaymentInformation> findByHolder(String holder);

}
