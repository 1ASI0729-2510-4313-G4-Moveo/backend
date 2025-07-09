package com.moveo.api.payment.interfaces.rest.transform;

import com.moveo.api.payment.domain.model.aggregate.Payment;
import com.moveo.api.payment.interfaces.rest.resources.PaymentResource;
import com.moveo.api.payment.interfaces.rest.resources.PaymentInformationResource;

public class PaymentResourceFromEntityAssembler {
    public static PaymentResource toResourceFromEntity(Payment entity, PaymentInformationResource paymentInformationResource) {
        return new PaymentResource(entity.getId(), entity.getAmount(), paymentInformationResource);
    }
}
