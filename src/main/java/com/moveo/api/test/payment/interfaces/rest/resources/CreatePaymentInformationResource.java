package com.moveo.api.test.payment.interfaces.rest.resources;

import com.moveo.api.test.payment.infrastructure.persistence.jpa.PaymentRepository;

public record CreatePaymentInformationResource(String holder, Long cardNumber, String expirationDate, String type){

}
