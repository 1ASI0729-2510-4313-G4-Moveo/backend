package com.moveo.api.iam.application.internal.queryservices;

import com.moveo.api.iam.domain.model.entities.Type;
import com.moveo.api.iam.domain.model.queries.GetAllTypesQuery;
import com.moveo.api.iam.domain.model.queries.GetTypeByNameQuery;
import com.moveo.api.iam.domain.services.TypeQueryService;
import com.moveo.api.iam.infrastructure.persistence.jpa.repositories.TypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * TypeQueryServiceImpl class
 * This class is used to handle the type queries
 */
@Service
public class TypeQueryServiceImpl implements TypeQueryService {
    private final TypeRepository typeRepository;

    /**
     * TypeQueryServiceImpl constructor
     * @param typeRepository the type repository
     */
    public TypeQueryServiceImpl(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    /**
     * Handle the get all types query
     * @param query the get all types query
     * @return List<Type> the list of types
     */
    @Override
    public List<Type> handle(GetAllTypesQuery query) {
        return typeRepository.findAll();
    }

    /**
     * Handle the get type by name query
     * @param query the get type by name query
     * @return Optional<Type> the type
     */
    @Override
    public Optional<Type> handle(GetTypeByNameQuery query) {
        return typeRepository.findByName(query.name());
    }
} 