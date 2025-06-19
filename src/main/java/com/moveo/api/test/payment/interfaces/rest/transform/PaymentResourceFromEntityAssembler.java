package com.moveo.api.test.payment.interfaces.rest.transform;

import com.moveo.api.test.payment.domain.model.aggregate.Payment;
import com.moveo.api.test.payment.interfaces.rest.resources.PaymentResource;

public class PaymentResourceFromEntityAssembler {
    public static PaymentResource toResourceFromEntity(Payment entity) {
        return new PaymentResource(entity.getId(), entity.getAmount(), entity.getPaymentInformationId());
    }
}
