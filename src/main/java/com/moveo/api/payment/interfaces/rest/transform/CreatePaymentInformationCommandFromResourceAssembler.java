package com.moveo.api.payment.interfaces.rest.transform;

import com.moveo.api.payment.domain.model.commands.CreatePaymentInformationCommand;
import com.moveo.api.payment.interfaces.rest.resources.CreatePaymentInformationResource;
import com.moveo.api.payment.interfaces.rest.resources.CreatePaymentResource;

public class CreatePaymentInformationCommandFromResourceAssembler {

    public static CreatePaymentInformationCommand toCommandFromResource(CreatePaymentInformationResource resource){

        return new CreatePaymentInformationCommand(resource.holder(), resource.cardNumber(), resource.expirationDate(), resource.type());
    }
}
