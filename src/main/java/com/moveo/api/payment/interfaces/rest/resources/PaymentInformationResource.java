package com.moveo.api.payment.interfaces.rest.resources;

public record PaymentInformationResource(Long id, Long userId, String holder, Long cardNumber, String expirationDate, String type) {
}
