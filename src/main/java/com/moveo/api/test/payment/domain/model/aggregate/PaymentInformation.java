package com.moveo.api.test.payment.domain.model.aggregate;


import com.moveo.api.test.payment.domain.model.commands.CreatePaymentInformationCommand;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class PaymentInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String holder;

    @Column(nullable = false)
    private Long cardNumber;

    @Column(nullable = false)
    private String expirationDate;

    @Column(nullable = false)
    private String type;


    protected PaymentInformation() {
    }

    public PaymentInformation(CreatePaymentInformationCommand command) {

        this.holder = command.holder();
        this.cardNumber = command.cardNumber();
        this.expirationDate = command.expirationDate();
        this.type = command.type();
    }
    // Getters and Setters
}
