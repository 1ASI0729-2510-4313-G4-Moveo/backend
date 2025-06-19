package com.moveo.api.rents.application.internal.commandservices;

import com.moveo.api.rents.domain.model.aggregate.Rent;
import com.moveo.api.rents.domain.model.commands.CreateRentCommand;
import com.moveo.api.rents.domain.services.RentCommandService;
import com.moveo.api.rents.infrastructure.persistence.jpa.RentsRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RentCommandServiceImpl implements RentCommandService {

    private final RentsRepository rentsRepository;

    public RentCommandServiceImpl(RentsRepository rentsRepository) {
        this.rentsRepository = rentsRepository;
    }

    @Override
    public Optional<Rent> handle(CreateRentCommand command) {
        if(rentsRepository.existsByStarTimeAndEndTime(command.starTime(), command.endTime())){
            throw new IllegalArgumentException("Rent already exists with Start Time and End Time");
        }

        var rents = new Rent(command);
        var createdRent = rentsRepository.save(rents);

        return Optional.of(createdRent);
    }



}
