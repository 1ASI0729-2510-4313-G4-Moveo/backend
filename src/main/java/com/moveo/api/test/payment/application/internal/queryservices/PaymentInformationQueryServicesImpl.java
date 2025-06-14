package com.moveo.api.test.payment.application.internal.queryservices;

import com.moveo.api.test.payment.domain.model.aggregate.PaymentInformation;
import com.moveo.api.test.payment.domain.model.queries.GetAllPaymentInformationQuery;
import com.moveo.api.test.payment.domain.model.queries.GetByHolderQuery;
import com.moveo.api.test.payment.domain.model.queries.GetPaymentInformationByIdQuery;
import com.moveo.api.test.payment.domain.services.PaymentInformationQueryService;
import com.moveo.api.test.payment.infrastructure.persistence.jpa.PaymentInformationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PaymentInformationQueryServicesImpl implements PaymentInformationQueryService {

    private final PaymentInformationRepository paymentInformationRepository;

    public PaymentInformationQueryServicesImpl(PaymentInformationRepository paymentInformationRepository) {
        this.paymentInformationRepository = paymentInformationRepository;
    }

    @Override
    public Optional<PaymentInformation> handle(GetPaymentInformationByIdQuery query) {
        return this.paymentInformationRepository.findById(query.Id());
    }

    @Override
    public Optional<PaymentInformation> handle(GetByHolderQuery query) {
        return this.paymentInformationRepository.findByHolder(query.holder());
    }

    @Override
    public List<PaymentInformation> handle(GetAllPaymentInformationQuery query) {
        return this.paymentInformationRepository.findAll();
    }
}
