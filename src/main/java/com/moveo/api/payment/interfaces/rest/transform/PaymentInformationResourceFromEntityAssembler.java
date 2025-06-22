package com.moveo.api.payment.interfaces.rest.transform;

import com.moveo.api.payment.domain.model.aggregate.Payment;
import com.moveo.api.payment.domain.model.aggregate.PaymentInformation;
import com.moveo.api.payment.interfaces.rest.resources.PaymentInformationResource;

public class PaymentInformationResourceFromEntityAssembler {
    public static PaymentInformationResource toResourceFromEntity(PaymentInformation entity) {
        return new PaymentInformationResource(entity.getId(), entity.getUserId(), entity.getHolder(), entity.getCardNumber(), entity.getExpirationDate(), entity.getType());
    }
}
