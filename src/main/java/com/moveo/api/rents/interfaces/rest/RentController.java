package com.moveo.api.rents.interfaces.rest;

import com.moveo.api.rents.domain.model.aggregate.Rent;
import com.moveo.api.rents.domain.model.commands.CreateRentCommand;
import com.moveo.api.rents.domain.model.queries.GetRentsByIdQuery;
import com.moveo.api.rents.domain.services.RentCommandService;
import com.moveo.api.rents.domain.services.RentQueryService;
import com.moveo.api.rents.interfaces.rest.resources.RentResource;
import com.moveo.api.rents.interfaces.rest.transform.CreateRentCommandFromResourceAssembler;
import com.moveo.api.rents.interfaces.rest.transform.RentResourceFromEntityAssembler;
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
@RequestMapping(value = "/api/v1/rent", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Rent", description = "Endpoints for Rent")
public class RentController {
    private final RentCommandService rentCommandService;
    private final RentQueryService rentQueryService;

    public RentController(RentCommandService rentCommandService, RentQueryService rentQueryService) {
        this.rentCommandService = rentCommandService;
        this.rentQueryService = rentQueryService;
    }

    @PostMapping
    @Operation(
            summary = "Create a Rent",
            description = "Creates a rent with the provided rent Start Time and End Time"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Rent Created"),
                    @ApiResponse(responseCode = "400", description = "Bad Request")
            }
    )
    public ResponseEntity<RentResource> createRent(@RequestBody CreateRentCommand resource) {
        var createRentCommand = CreateRentCommandFromResourceAssembler.toCommandFromResource(resource);
        Optional<Rent> rent = rentCommandService.handle(createRentCommand );
        return rent.map(
                source -> new ResponseEntity<>(RentResourceFromEntityAssembler.toResourceFromEntity(source), CREATED)

        ).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("{id}?id2=123")
    @Operation(
            summary = "Get a Rent by ID",
            description = "Gets a Rent with ID param"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Rent found"),
                    @ApiResponse(responseCode = "404", description = "Not found")
            }
    )
    public ResponseEntity<RentResource> getRentById(@PathVariable("id") Long id) {
        Optional<Rent> rent = rentQueryService.handle(new GetRentsByIdQuery(id));
        return rent.map(
                source -> ResponseEntity.ok(RentResourceFromEntityAssembler.toResourceFromEntity(source))
        ).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
