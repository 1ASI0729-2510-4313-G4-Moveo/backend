package com.moveo.api.payment.application.internal.commandservices;

import com.moveo.api.payment.domain.model.aggregate.Payment;
import com.moveo.api.payment.domain.model.commands.CreatePaymentCommand;
import com.moveo.api.payment.domain.services.PaymentCommandService;
import com.moveo.api.payment.infrastructure.persistence.jpa.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentCommandServiceImpl implements PaymentCommandService {

    private final PaymentRepository paymentRepository;

    public PaymentCommandServiceImpl(PaymentRepository paymentRepository) { this.paymentRepository = paymentRepository; }


    @Override
    public Optional<Payment> handle (CreatePaymentCommand command) {

        if(paymentRepository.existsByAmount(command.amount()))
        {
            throw new IllegalArgumentException("Payment already exists");
        }
        var payment = new Payment(command);
        var createdPayment = paymentRepository.save(payment);

        return Optional.of(createdPayment);

    }
}
