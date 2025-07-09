package com.moveo.api.payment.interfaces.rest.resources;

public record PaymentResource(Long id, Float amount, PaymentInformationResource paymentInformation) {
}
