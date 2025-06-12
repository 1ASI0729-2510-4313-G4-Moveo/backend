package com.moveo.api.test.rents.application.internal.queryservices;

import com.moveo.api.test.rents.domain.model.aggregate.Rent;
import com.moveo.api.test.rents.domain.model.queries.GetAllRentsQuery;
import com.moveo.api.test.rents.domain.model.queries.GetRentsByIdQuery;
import com.moveo.api.test.rents.domain.services.RentQueryService;
import com.moveo.api.test.rents.infrastructure.persistence.jpa.RentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentQueryServiceImpl implements RentQueryService {

    private final RentsRepository rentsRepository;

    public RentQueryServiceImpl(RentsRepository rentsRepository) {
        this.rentsRepository = rentsRepository;
    }

    @Override
    public List<Rent> handle(GetAllRentsQuery query) {
        return this.rentsRepository.findAll();
    }

    @Override
    public Optional<Rent> handle(GetRentsByIdQuery query) {
        return this.rentsRepository.findById(query.id());
    }
}
