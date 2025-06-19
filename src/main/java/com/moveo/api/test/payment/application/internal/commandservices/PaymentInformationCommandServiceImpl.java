package com.moveo.api.test.payment.application.internal.commandservices;

import com.moveo.api.test.payment.domain.model.aggregate.PaymentInformation;
import com.moveo.api.test.payment.domain.model.commands.CreatePaymentInformationCommand;
import com.moveo.api.test.payment.domain.services.PaymentInformationCommandService;
import com.moveo.api.test.payment.infrastructure.persistence.jpa.PaymentInformationRepository;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class PaymentInformationCommandServiceImpl implements PaymentInformationCommandService {

    private final PaymentInformationRepository paymentInformationRepository;

    public PaymentInformationCommandServiceImpl(PaymentInformationRepository paymentInformationRepository) {
        this.paymentInformationRepository = paymentInformationRepository;
    }


    @Override
    public Optional<PaymentInformation> handle(CreatePaymentInformationCommand command) {

        if(paymentInformationRepository.existsByHolderAndCardNumber(command.holder(), command.cardNumber()))
        {
          throw new IllegalArgumentException("Payment Information already exists");
        }
        var paymentInformation = new PaymentInformation(command);
        var createdPaymentInformation = paymentInformationRepository.save(paymentInformation);

        return Optional.of(createdPaymentInformation);
    }
}

