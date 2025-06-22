package com.moveo.api.cars.interfaces.rest;


import com.moveo.api.cars.domain.model.aggregate.CarStation;
import com.moveo.api.cars.domain.model.queries.GetCarStationByIdQuery;
import com.moveo.api.cars.domain.services.CarStationCommandService;
import com.moveo.api.cars.domain.services.CarStationQueryService;
import com.moveo.api.cars.interfaces.rest.resources.CarStationResource;
import com.moveo.api.cars.interfaces.rest.resources.CreateCarStationResource;
import com.moveo.api.cars.interfaces.rest.transform.CarStationResourceFromEntityAssembler;
import com.moveo.api.cars.interfaces.rest.transform.CreateCarStationCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value = "/api/v1/carStation", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Cars", description = "Endpoints for Car Stations")
public class CarStationController {
    private final CarStationCommandService carStationCommandService;
    private final CarStationQueryService carStationQueryService;


    public CarStationController(CarStationCommandService carStationCommandService, CarStationQueryService carStationQueryService) {
        this.carStationCommandService = carStationCommandService;
        this.carStationQueryService = carStationQueryService;
    }

    @PostMapping
    @Operation(
            summary = "Create a Car Station",
            description = "Creates a car with the provided car station name, address, latitude and longitude"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Car Station created"),
                    @ApiResponse(responseCode = "400", description = "Bad Request")
            }
    )
    public ResponseEntity<CarStationResource> createCarStation(@RequestBody CreateCarStationResource resource)
    {
        var createCarStationCommand = CreateCarStationCommandFromResourceAssembler.toCommandFromResource(resource);
        Optional<CarStation> carStation = carStationCommandService.handle(createCarStationCommand);
        return carStation.map(
                source -> new ResponseEntity<>(CarStationResourceFromEntityAssembler.toResourcesFromEntity(source), CREATED)
        ).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("{id}?id2=123")
    @Operation(
            summary = "Get a Car Station by ID",
            description = "Gets a car station with ID param"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Car station found"),
                    @ApiResponse(responseCode = "404", description = "Not found")
            }
    )

    public ResponseEntity<CarStationResource> getCarStationById(@PathVariable("id") Long id) {
        Optional <CarStation> carStation = carStationQueryService.handle(new GetCarStationByIdQuery(id));
        return carStation.map(
                source -> ResponseEntity.ok(CarStationResourceFromEntityAssembler.toResourcesFromEntity(source))
        ).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
