package com.moveo.api.payment.domain.model.commands;

public record CreatePaymentCommand(Float amount, Long paymentInformationId) {
    public CreatePaymentCommand {
        if (amount == null) {
            throw new IllegalArgumentException("Amount cannot be null");
        }
        if (paymentInformationId == null) {
            throw new IllegalArgumentException("paymentInformationId cannot be null");
        }
    }
}
