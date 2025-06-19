package com.moveo.api.test.records.interfaces.rest;

import com.moveo.api.test.records.domain.model.aggregate.CarRating;
import com.moveo.api.test.records.domain.model.queries.GetAverageRatingByCarIdQuery;
import com.moveo.api.test.records.domain.services.CarRatingCommandService;
import com.moveo.api.test.records.domain.services.CarRatingQueryService;
import com.moveo.api.test.records.interfaces.rest.resources.CarRatingResource;
import com.moveo.api.test.records.interfaces.rest.resources.CreateCarRatingResource;
import com.moveo.api.test.records.interfaces.rest.transform.CarRatingResourceFromEntityAssembler;
import com.moveo.api.test.records.interfaces.rest.transform.CreateCarRatingCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value = "/api/v1/ratings", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Car Ratings", description = "Endpoints for Car Ratings")
public class CarRatingController {

    private final CarRatingCommandService carRatingCommandService;
    private final CarRatingQueryService carRatingQueryService;

    public CarRatingController(CarRatingCommandService carRatingCommandService, CarRatingQueryService carRatingQueryService) {
        this.carRatingCommandService = carRatingCommandService;
        this.carRatingQueryService = carRatingQueryService;
    }

    @PostMapping
    @Operation(
            summary = "Create a Car Rating",
            description = "Creates a car rating with the provided user, car, rental and rating information"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Car Rating created"),
                    @ApiResponse(responseCode = "400", description = "Bad request")
            }
    )
    public ResponseEntity<CarRatingResource> createCarRating(@RequestBody CreateCarRatingResource resource) {
        var createCarRatingCommand = CreateCarRatingCommandFromResourceAssembler.toCommandFromResource(resource);
        Optional<CarRating> carRating = carRatingCommandService.handle(createCarRatingCommand);
        return carRating.map(
                source -> new ResponseEntity<>(CarRatingResourceFromEntityAssembler.toResourceFromEntity(source), CREATED)
        ).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/cars/{carId}/average")
    @Operation(
            summary = "Get Average Rating for a Car",
            description = "Gets the average rating for a specific car"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Average rating found"),
                    @ApiResponse(responseCode = "404", description = "Car not found")
            }
    )
    public ResponseEntity<Map<String, Double>> getAverageRating(@PathVariable("carId") Long carId) {
        Double averageRating = carRatingQueryService.handle(new GetAverageRatingByCarIdQuery(carId));
        return ResponseEntity.ok(Map.of("averageRating", averageRating));
    }
}
