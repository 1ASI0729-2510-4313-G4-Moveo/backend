package com.moveo.api.payment.domain.model.aggregate;

import com.moveo.api.payment.domain.model.commands.CreatePaymentCommand;
import jakarta.persistence.*;
import lombok.Getter;
@Entity

@Getter
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Float amount;

    @Column(nullable = false)
    private Long paymentInformationId;

    protected Payment() {
    }

    public Payment(CreatePaymentCommand command) {
        this.amount = command.amount();
        this.paymentInformationId = command.paymentInformationId();
    }
}
