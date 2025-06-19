package com.moveo.api.test.payment.application.internal.queryservices;


import com.moveo.api.test.payment.domain.model.aggregate.Payment;
import com.moveo.api.test.payment.domain.model.queries.GetAllPaymentInformationQuery;
import com.moveo.api.test.payment.domain.model.queries.GetPaymentByIdQuery;
import com.moveo.api.test.payment.domain.services.PaymentQueryService;
import com.moveo.api.test.payment.infrastructure.persistence.jpa.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentQueryServiceImpl implements PaymentQueryService {

    private final PaymentRepository paymentRepository;

    PaymentQueryServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Optional<Payment> handle(GetPaymentByIdQuery query) {
        return this.paymentRepository.findById(query.id());
    }

    @Override
    public List<Payment> handle(GetAllPaymentInformationQuery query) {
        return this.paymentRepository.findAll();
    }

}


