package com.moveo.api.rents.interfaces.rest.transform;

import com.moveo.api.rents.domain.model.aggregate.Rent;
import com.moveo.api.rents.interfaces.rest.resources.RentResource;
import com.moveo.api.payment.domain.services.PaymentInformationQueryService;
import com.moveo.api.payment.domain.model.queries.GetPaymentInformationByIdQuery;
import com.moveo.api.payment.interfaces.rest.transform.PaymentInformationResourceFromEntityAssembler;
import com.moveo.api.iam.domain.services.UserQueryService;
import com.moveo.api.iam.domain.model.queries.GetUserByIdQuery;
import com.moveo.api.iam.interfaces.rest.transform.UserResourceFromEntityAssembler;
import com.moveo.api.cars.domain.services.CarStationQueryService;
import com.moveo.api.cars.domain.model.queries.GetCarStationByIdQuery;
import com.moveo.api.cars.interfaces.rest.transform.CarStationResourceFromEntityAssembler;
import com.moveo.api.cars.domain.services.CarQueryService;
import com.moveo.api.cars.domain.model.queries.GetCarsByIdQuery;
import com.moveo.api.cars.interfaces.rest.transform.CarResourceFromEntityAssembler;
import com.moveo.api.cars.domain.services.StationQueryService;
import com.moveo.api.cars.interfaces.rest.transform.StationResourceFromEntityAssembler;

public class RentResourceFromEntityAssembler {
    public static RentResource toResourceFromEntity(
            Rent entity,
            PaymentInformationQueryService paymentInformationQueryService,
            UserQueryService userQueryService,
            CarStationQueryService carStationQueryService,
            CarQueryService carQueryService,
            StationQueryService stationQueryService
    ) {
        var payment = paymentInformationQueryService.handle(new GetPaymentInformationByIdQuery(entity.getPaymentId()))
                .map(PaymentInformationResourceFromEntityAssembler::toResourceFromEntity)
                .orElse(null);
        var user = userQueryService.handle(new GetUserByIdQuery(entity.getUserId()))
                .map(UserResourceFromEntityAssembler::toResourceFromEntity)
                .orElse(null);
        var carStation = carStationQueryService.handle(new GetCarStationByIdQuery(entity.getCarsStationsId()))
                .map(cs -> {
                    var car = carQueryService.handle(new GetCarsByIdQuery(cs.getCarId()))
                        .map(CarResourceFromEntityAssembler::toResourceFromEntity)
                        .orElse(null);
                    var station = stationQueryService.getById(cs.getStationId())
                        .map(StationResourceFromEntityAssembler::toResourceFromEntity)
                        .orElse(null);
                    return CarStationResourceFromEntityAssembler.toResourceFromEntity(cs, car, station);
                })
                .orElse(null);
        return new RentResource(
                entity.getId(),
                entity.getStarTime(),
                entity.getEndTime(),
                payment,
                user,
                carStation
        );
    }
}
