package com.moveo.api.payment.interfaces.rest.resources;

import com.moveo.api.payment.infrastructure.persistence.jpa.PaymentRepository;

public record CreatePaymentInformationResource(String holder, Long cardNumber, String expirationDate, String type){

}
