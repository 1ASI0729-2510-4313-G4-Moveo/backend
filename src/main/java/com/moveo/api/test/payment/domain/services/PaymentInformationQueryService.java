package com.moveo.api.test.payment.domain.services;

import com.moveo.api.test.payment.domain.model.aggregate.PaymentInformation;
import com.moveo.api.test.payment.domain.model.queries.GetAllPaymentInformationQuery;
import com.moveo.api.test.payment.domain.model.queries.GetByHolderQuery;
import com.moveo.api.test.payment.domain.model.queries.GetPaymentInformationByIdQuery;

import java.util.List;
import java.util.Optional;

public interface PaymentInformationQueryService {
    Optional<PaymentInformation> handle(GetPaymentInformationByIdQuery query);
    Optional<PaymentInformation> handle(GetByHolderQuery query);
    List<PaymentInformation> handle(GetAllPaymentInformationQuery query);
}
