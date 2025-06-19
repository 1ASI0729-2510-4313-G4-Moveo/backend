package com.moveo.api.providers.application.internal.queryservices;

import com.moveo.api.cars.infrastructure.persistence.jpa.CarsRepository;
import com.moveo.api.providers.domain.model.queries.GetProviderReservationsQuery;
import com.moveo.api.providers.domain.services.ProviderQueryService;
import com.moveo.api.rents.domain.model.aggregate.Rent;
import com.moveo.api.rents.infrastructure.persistence.jpa.RentsRepository;
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

    //@Override
    //public List<Rent> handle(GetProviderReservationsQuery query) {
        // Obtener todos los autos del proveedor
        //var providerCars = carsRepository.findByCarsStationsId(query.providerId());

        //if (providerCars.isEmpty()) {
          //  return List.of();
        //}

        // Extraer los IDs de los autos
        //var carIds = providerCars.stream()
          //      .map(car -> car.getId())
            //    .toList();

        // Obtener todas las reservas de esos autos
        //return rentsRepository.findByCarId(carIds);
    //}
}
