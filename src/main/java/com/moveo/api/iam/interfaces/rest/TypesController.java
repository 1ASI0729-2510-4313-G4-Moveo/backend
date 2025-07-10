package com.moveo.api.iam.interfaces.rest;

import com.moveo.api.iam.domain.model.queries.GetAllTypesQuery;
import com.moveo.api.iam.domain.services.TypeQueryService;
import com.moveo.api.iam.interfaces.rest.resources.TypeResource;
import com.moveo.api.iam.interfaces.rest.transform.TypeResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *  Types Controller
 *  This controller is responsible for handling all the requests related to types
 */
@RestController
@RequestMapping(value = "/ap/v1/types", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Types", description = "Available Type Endpoints")
public class TypesController {
    private final TypeQueryService typeQueryService;

    public TypesController(TypeQueryService typeQueryService) {
        this.typeQueryService = typeQueryService;
    }

    /**
     * Get all types
     * @return List of type resources
     * @see TypeResource
     */
    @GetMapping
    @Operation(summary = "Get all types", description = "Get all the types available in the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Types retrieved successfully."),
            @ApiResponse(responseCode = "401", description = "Unauthorized.")})
    public ResponseEntity<List<TypeResource>> getAllTypes() {
        var getAllTypesQuery = new GetAllTypesQuery();
        var types = typeQueryService.handle(getAllTypesQuery);
        var typeResources = types.stream().map(TypeResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(typeResources);
    }
} 