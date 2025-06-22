package com.moveo.api.payment.domain.model.commands;

public record CreatePaymentCommand( Float amount) {
 public CreatePaymentCommand {

     if(amount == null) {
         throw new IllegalArgumentException("Amount cannot be null");
     }

 }

}
