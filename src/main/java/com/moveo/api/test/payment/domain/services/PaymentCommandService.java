package com.moveo.api.test.payment.domain.services;

import com.moveo.api.test.payment.domain.model.aggregate.Payment;
import com.moveo.api.test.payment.domain.model.commands.CreatePaymentCommand;

import java.util.Optional;

public interface PaymentCommandService {
   Optional<Payment> handle(CreatePaymentCommand createPaymentCommand);
}
