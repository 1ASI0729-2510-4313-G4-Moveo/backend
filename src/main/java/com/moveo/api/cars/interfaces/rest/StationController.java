package com.moveo.api.cars.interfaces.rest;

import com.moveo.api.cars.domain.model.aggregate.Station;
import com.moveo.api.cars.domain.model.commands.CreateStationCommand;
import com.moveo.api.cars.domain.services.StationCommandService;
import com.moveo.api.cars.domain.services.StationQueryService;
import com.moveo.api.cars.interfaces.rest.resources.CreateStationResource;
import com.moveo.api.cars.interfaces.rest.resources.StationResource;
import com.moveo.api.cars.interfaces.rest.transform.CreateStationCommandFromResourceAssembler;
import com.moveo.api.cars.interfaces.rest.transform.StationResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value = "/api/v1/stations", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Stations", description = "Endpoints for Stations")
public class StationController {
    private final StationCommandService stationCommandService;
    private final StationQueryService stationQueryService;

    public StationController(StationCommandService stationCommandService, StationQueryService stationQueryService) {
        this.stationCommandService = stationCommandService;
        this.stationQueryService = stationQueryService;
    }

    @PostMapping
    @Operation(summary = "Create a Station", description = "Creates a station with the provided data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Station created"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    public ResponseEntity<StationResource> createStation(@RequestBody CreateStationResource resource) {
        CreateStationCommand command = CreateStationCommandFromResourceAssembler.toCommandFromResource(resource);
        Optional<Station> station = stationCommandService.handle(command);
        return station.map(s -> new ResponseEntity<>(StationResourceFromEntityAssembler.toResourceFromEntity(s), CREATED))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a Station by ID", description = "Gets a station by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Station found"),
            @ApiResponse(responseCode = "404", description = "Not found")
    })
    public ResponseEntity<StationResource> getStationById(@PathVariable("id") Long id) {
        Optional<Station> station = stationQueryService.getById(id);
        return station.map(s -> ResponseEntity.ok(StationResourceFromEntityAssembler.toResourceFromEntity(s)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    @Operation(summary = "Get all Stations", description = "Gets all stations")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Stations found")
    })
    public ResponseEntity<List<StationResource>> getAllStations() {
        List<Station> stations = stationQueryService.getAll();
        List<StationResource> resources = stations.stream()
                .map(StationResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(resources);
    }
} 