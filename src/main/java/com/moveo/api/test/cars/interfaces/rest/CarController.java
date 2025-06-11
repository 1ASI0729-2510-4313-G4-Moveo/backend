package com.moveo.api.test.cars.interfaces.rest;

import com.moveo.api.test.cars.domain.model.aggregate.Cars;
import com.moveo.api.test.cars.domain.model.queries.GetCarsByIdQuery;
import com.moveo.api.test.cars.domain.services.CarCommandService;
import com.moveo.api.test.cars.domain.services.CarQueryService;
import com.moveo.api.test.cars.interfaces.rest.resources.CarResource;
import com.moveo.api.test.cars.interfaces.rest.resources.CreateCarResource;
import com.moveo.api.test.cars.interfaces.rest.transform.CarResourceFromEntityAssembler;
import com.moveo.api.test.cars.interfaces.rest.transform.CreateCarCommandFromResourceAssembler;
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
@RequestMapping(value = "/api/v1/cars", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Cars", description = "Endpoints for Cars")


public class CarController {

    private final CarCommandService carCommandService;
    private final CarQueryService carQueryService;

    public CarController(CarCommandService carCommandService, CarQueryService carQueryService) {
        this.carCommandService = carCommandService;
        this.carQueryService = carQueryService;
    }

    @PostMapping
    @Operation(
            summary = "Create a Car",
            description = "Creates a car with the provided car condition and availability"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Car created"),
                    @ApiResponse(responseCode = "400", description = "Bad request")
            }
    )
    public ResponseEntity<CarResource> createCar(@RequestBody CreateCarResource resource)
    {
        var createCarCommand = CreateCarCommandFromResourceAssembler.toCommandFromResource(resource);
        Optional<Cars> cars = carCommandService.handle(createCarCommand);
        return cars.map(
                source -> new ResponseEntity<>(CarResourceFromEntityAssembler.toResourceFromEntity(source), CREATED)
        ).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("{id}?id2=123")
    @Operation(
            summary = "Get a Car by ID",
            description = "Gets a car with ID param"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Car found"),
                    @ApiResponse(responseCode = "404", description = "Not found")
            }
    )
    public ResponseEntity<CarResource> getCarById(@PathVariable("id") Long id) {
        Optional<Cars> cars = carQueryService.handle(new GetCarsByIdQuery(id));
        return cars.map(
                source -> ResponseEntity.ok(CarResourceFromEntityAssembler.toResourceFromEntity(source))
        ).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
