package com.moveo.api.payment.interfaces.rest.transform;

import com.moveo.api.payment.domain.model.commands.CreatePaymentInformationCommand;
import com.moveo.api.payment.interfaces.rest.resources.CreatePaymentInformationResource;

public class CreatePaymentInformationCommandFromResourceAssembler {

    public static CreatePaymentInformationCommand toCommandFromResource(CreatePaymentInformationResource resource){
        return new CreatePaymentInformationCommand(resource.userId(), resource.holder(), resource.cardNumber(), resource.expirationDate(), resource.type());
    }
}
