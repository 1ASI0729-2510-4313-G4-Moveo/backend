package com.moveo.api.payment.interfaces.rest.transform;

import com.moveo.api.payment.domain.model.commands.CreatePaymentCommand;
import com.moveo.api.payment.interfaces.rest.resources.CreatePaymentResource;

public class CreatePaymentCommandFromResourceAssembler {

    public static CreatePaymentCommand toCommandFromResource(CreatePaymentResource resource){
        return new CreatePaymentCommand(resource.amount());
    }
}
