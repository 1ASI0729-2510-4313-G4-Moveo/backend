package com.moveo.api.payment.domain.services;

import com.moveo.api.payment.domain.model.aggregate.PaymentInformation;
import com.moveo.api.payment.domain.model.commands.CreatePaymentInformationCommand;


import java.util.Optional;

public interface PaymentInformationCommandService {
    Optional<PaymentInformation> handle(CreatePaymentInformationCommand createPaymentInformationCommand);
}
