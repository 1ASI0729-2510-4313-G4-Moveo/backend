package com.moveo.api.test.rents.domain.services;

import com.moveo.api.test.rents.domain.model.aggregate.Rent;
import com.moveo.api.test.rents.domain.model.commands.CreateRentCommand;

import java.util.Optional;

public interface RentCommandService {

    Optional<Rent> handle(CreateRentCommand createRentCommand);
}
