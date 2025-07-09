package com.moveo.api.rents.interfaces.rest.resources;

import com.moveo.api.payment.interfaces.rest.resources.PaymentInformationResource;
import com.moveo.api.iam.interfaces.rest.resources.UserResource;
import com.moveo.api.cars.interfaces.rest.resources.CarStationResource;
import java.util.Date;

public record RentResource(Long id, Date starTime, Date endTime, PaymentInformationResource payment, UserResource user, CarStationResource carStation) {

}
