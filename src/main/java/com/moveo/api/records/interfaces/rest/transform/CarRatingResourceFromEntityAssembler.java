package com.moveo.api.records.interfaces.rest.transform;

import com.moveo.api.records.domain.model.aggregate.CarRating;
import com.moveo.api.records.interfaces.rest.resources.CarRatingResource;
import com.moveo.api.iam.interfaces.rest.resources.UserResource;
import com.moveo.api.cars.interfaces.rest.resources.CarResource;
import com.moveo.api.rents.interfaces.rest.resources.RentResource;
import com.moveo.api.iam.domain.services.UserQueryService;
import com.moveo.api.cars.domain.services.CarQueryService;
import com.moveo.api.rents.domain.services.RentQueryService;
import com.moveo.api.iam.domain.model.queries.GetUserByIdQuery;
import com.moveo.api.cars.domain.model.queries.GetCarsByIdQuery;
import com.moveo.api.rents.domain.model.queries.GetRentsByIdQuery;
import com.moveo.api.iam.interfaces.rest.transform.UserResourceFromEntityAssembler;
import com.moveo.api.cars.interfaces.rest.transform.CarResourceFromEntityAssembler;
import com.moveo.api.rents.interfaces.rest.transform.RentResourceFromEntityAssembler;
import com.moveo.api.payment.domain.services.PaymentInformationQueryService;
import com.moveo.api.cars.domain.services.CarStationQueryService;
import com.moveo.api.cars.domain.services.StationQueryService;

public class CarRatingResourceFromEntityAssembler {
    public static CarRatingResource toResourceFromEntity(
            CarRating entity,
            UserQueryService userQueryService,
            CarQueryService carQueryService,
            RentQueryService rentQueryService,
            PaymentInformationQueryService paymentInformationQueryService,
            CarStationQueryService carStationQueryService,
            StationQueryService stationQueryService
    ) {
        UserResource user = userQueryService.handle(new GetUserByIdQuery(entity.getUserId()))
                .map(UserResourceFromEntityAssembler::toResourceFromEntity)
                .orElse(null);
        CarResource car = carQueryService.handle(new GetCarsByIdQuery(entity.getCarId()))
                .map(CarResourceFromEntityAssembler::toResourceFromEntity)
                .orElse(null);
        RentResource rent = rentQueryService.handle(new GetRentsByIdQuery(entity.getRentalId()))
                .map(r -> RentResourceFromEntityAssembler.toResourceFromEntity(
                        r,
                        paymentInformationQueryService,
                        userQueryService,
                        carStationQueryService,
                        carQueryService,
                        stationQueryService
                ))
                .orElse(null);
        return new CarRatingResource(
                entity.getId(),
                user,
                car,
                rent,
                entity.getRating(),
                entity.getRatingDate()
        );
    }
}
