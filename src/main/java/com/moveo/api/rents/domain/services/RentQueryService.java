package com.moveo.api.rents.domain.services;

import com.moveo.api.rents.domain.model.aggregate.Rent;
import com.moveo.api.rents.domain.model.queries.GetAllRentsQuery;
import com.moveo.api.rents.domain.model.queries.GetRentsByIdQuery;

import java.util.List;
import java.util.Optional;

public interface RentQueryService {
    List<Rent> handle(GetAllRentsQuery query);
    Optional<Rent> handle(GetRentsByIdQuery query);
}
