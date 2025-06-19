package com.moveo.api.test.payment.domain.services;

import com.moveo.api.test.payment.domain.model.aggregate.PaymentInformation;
import com.moveo.api.test.payment.domain.model.commands.CreatePaymentInformationCommand;


import java.util.Optional;

public interface PaymentInformationCommandService {
    Optional<PaymentInformation> handle(CreatePaymentInformationCommand createPaymentInformationCommand);
}
