package com.moveo.api.payment.domain.model.commands;

public record CreatePaymentInformationCommand(String holder, Long cardNumber, String expirationDate, String type) {
    public CreatePaymentInformationCommand {

        if( holder==null || holder.isEmpty()  ) {
            throw new IllegalArgumentException("Holder cannot be null or empty");
        }

        if( cardNumber==null  ) {
            throw new IllegalArgumentException("Card number cannot be null");
        }

        if( expirationDate==null || expirationDate.isEmpty()  ) {
            throw new IllegalArgumentException("Expiration Date cannot be null");
        }
        if( type==null || type.isEmpty() ) {
            throw new IllegalArgumentException("Type cannot be null");
        }
    }
}
