package com.moveo.api.cars.interfaces.rest;


import com.moveo.api.cars.domain.model.aggregate.CarStation;
import com.moveo.api.cars.domain.model.queries.GetCarStationByIdQuery;
import com.moveo.api.cars.domain.model.queries.GetCarsByIdQuery;
import com.moveo.api.cars.domain.services.CarStationCommandService;
import com.moveo.api.cars.domain.services.CarStationQueryService;
import com.moveo.api.cars.domain.services.CarQueryService;
import com.moveo.api.cars.domain.services.StationQueryService;
import com.moveo.api.cars.interfaces.rest.resources.CarResource;
import com.moveo.api.cars.interfaces.rest.resources.CarStationResource;
import com.moveo.api.cars.interfaces.rest.resources.CreateCarStationResource;
import com.moveo.api.cars.interfaces.rest.resources.StationResource;
import com.moveo.api.cars.interfaces.rest.transform.CarResourceFromEntityAssembler;
import com.moveo.api.cars.interfaces.rest.transform.CarStationResourceFromEntityAssembler;
import com.moveo.api.cars.interfaces.rest.transform.CreateCarStationCommandFromResourceAssembler;
import com.moveo.api.cars.interfaces.rest.transform.StationResourceFromEntityAssembler;
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
    private final CarQueryService carQueryService;
    private final StationQueryService stationQueryService;


    public CarStationController(CarStationCommandService carStationCommandService, CarStationQueryService carStationQueryService, CarQueryService carQueryService, StationQueryService stationQueryService) {
        this.carStationCommandService = carStationCommandService;
        this.carStationQueryService = carStationQueryService;
        this.carQueryService = carQueryService;
        this.stationQueryService = stationQueryService;
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
        return carStation.map(source -> {
            var car = carQueryService.handle(new GetCarsByIdQuery(source.getCarId())).orElse(null);
            var station = stationQueryService.getById(source.getStationId()).orElse(null);
            CarResource carResource = car != null ? CarResourceFromEntityAssembler.toResourceFromEntity(car) : null;
            StationResource stationResource = station != null ? StationResourceFromEntityAssembler.toResourceFromEntity(station) : null;
            return new ResponseEntity<>(CarStationResourceFromEntityAssembler.toResourceFromEntity(source, carResource, stationResource), CREATED);
        }).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/{id}")
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
        return carStation.map(source -> {
            var car = carQueryService.handle(new GetCarsByIdQuery(source.getCarId())).orElse(null);
            var station = stationQueryService.getById(source.getStationId()).orElse(null);
            CarResource carResource = car != null ? CarResourceFromEntityAssembler.toResourceFromEntity(car) : null;
            StationResource stationResource = station != null ? StationResourceFromEntityAssembler.toResourceFromEntity(station) : null;
            return ResponseEntity.ok(CarStationResourceFromEntityAssembler.toResourceFromEntity(source, carResource, stationResource));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
