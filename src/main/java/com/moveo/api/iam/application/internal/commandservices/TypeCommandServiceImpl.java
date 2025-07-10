package com.moveo.api.iam.application.internal.commandservices;

import com.moveo.api.iam.domain.model.commands.SeedTypesCommand;
import com.moveo.api.iam.domain.model.entities.Type;
import com.moveo.api.iam.domain.model.valueobjects.Types;
import com.moveo.api.iam.domain.services.TypeCommandService;
import com.moveo.api.iam.infrastructure.persistence.jpa.repositories.TypeRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Implementation of {@link TypeCommandService} to handle {@link SeedTypesCommand}
 */
@Service
public class TypeCommandServiceImpl implements TypeCommandService {

    private final TypeRepository typeRepository;

    public TypeCommandServiceImpl(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    /**
     * This method will handle the {@link SeedTypesCommand} and will create the types if not exists
     * @param command {@link SeedTypesCommand}
     * @see SeedTypesCommand
     */
    @Override
    public void handle(SeedTypesCommand command) {
        Arrays.stream(Types.values()).forEach(type -> {
            if(!typeRepository.existsByName(type)) {
                typeRepository.save(new Type(Types.valueOf(type.name())));
            }
        } );
    }
} 