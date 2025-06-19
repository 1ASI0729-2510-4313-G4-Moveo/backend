package com.moveo.api.test.payment.domain.services;

import com.moveo.api.test.payment.domain.model.aggregate.Payment;
import com.moveo.api.test.payment.domain.model.queries.GetAllPaymentInformationQuery;
import com.moveo.api.test.payment.domain.model.queries.GetPaymentByIdQuery;

import java.util.List;
import java.util.Optional;

public interface PaymentQueryService {
    Optional<Payment> handle(GetPaymentByIdQuery query);
    List<Payment> handle(GetAllPaymentInformationQuery query);
}
