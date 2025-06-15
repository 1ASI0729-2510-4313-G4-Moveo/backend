package com.moveo.api.test.providers.domain.services;

import com.moveo.api.test.providers.domain.model.queries.GetProviderReservationsQuery;
import com.moveo.api.test.rents.domain.model.aggregate.Rent;

import java.util.List;

public interface ProviderQueryService {
    List<Rent> handle(GetProviderReservationsQuery query);
}
