package com.moveo.api.test.providers.application.internal.queryservices;

import com.moveo.api.test.cars.infrastructure.persistence.jpa.CarsRepository;
import com.moveo.api.test.providers.domain.model.queries.GetProviderReservationsQuery;
import com.moveo.api.test.providers.domain.services.ProviderQueryService;
import com.moveo.api.test.rents.domain.model.aggregate.Rent;
import com.moveo.api.test.rents.infrastructure.persistence.jpa.RentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderQueryServiceImpl implements ProviderQueryService {

    private final CarsRepository carsRepository;
    private final RentsRepository rentsRepository;

    public ProviderQueryServiceImpl(CarsRepository carsRepository, RentsRepository rentsRepository) {
        this.carsRepository = carsRepository;
        this.rentsRepository = rentsRepository;
    }

    @Override
    public List<Rent> handle(GetProviderReservationsQuery query) {
        // Obtener todos los autos del proveedor
        var providerCars = carsRepository.findByCarsStationsId(query.providerId());
        
        if (providerCars.isEmpty()) {
            return List.of();
        }
        
        // Extraer los IDs de los autos
        var carIds = providerCars.stream()
                .map(car -> car.getId())
                .toList();
        
        // Obtener todas las reservas de esos autos
        return rentsRepository.findByCarIdIn(carIds);
    }
}
