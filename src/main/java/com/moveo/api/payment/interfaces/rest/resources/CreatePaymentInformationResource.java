package com.moveo.api.payment.interfaces.rest.resources;

import com.moveo.api.payment.infrastructure.persistence.jpa.PaymentRepository;

public record CreatePaymentInformationResource(Long userId, String holder, Long cardNumber, String expirationDate, String type){}
