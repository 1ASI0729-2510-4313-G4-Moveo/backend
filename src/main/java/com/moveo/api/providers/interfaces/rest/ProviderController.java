package com.moveo.api.providers.interfaces.rest;

import com.moveo.api.providers.domain.model.queries.GetProviderReservationsQuery;
import com.moveo.api.providers.domain.services.ProviderQueryService;
import com.moveo.api.providers.interfaces.rest.resources.ProviderReservationResource;
import com.moveo.api.providers.interfaces.rest.transform.ProviderReservationResourceFromEntityAssembler;
import com.moveo.api.rents.domain.model.aggregate.Rent;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/providers", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Providers", description = "Endpoints for Provider Management")
public class ProviderController {

    private final ProviderQueryService providerQueryService;

    public ProviderController(ProviderQueryService providerQueryService) {
        this.providerQueryService = providerQueryService;
    }

    //@GetMapping("/{providerId}/reservations")
    //@Operation(
    //        summary = "Get Provider Reservations",
    //        description = "Gets all reservations made to vehicles owned by the provider"
    //)
    //@ApiResponses(
    //        value = {
    //                @ApiResponse(responseCode = "200", description = "Reservations found"),
    //                @ApiResponse(responseCode = "404", description = "Provider not found")
    //        }
    //)
    //public ResponseEntity<?> getProviderReservations(@PathVariable("providerId") Long providerId) {
        //List<Rent> reservations = providerQueryService.handle(new GetProviderReservationsQuery(providerId));
        
        //if (reservations.isEmpty()) {
          //  return ResponseEntity.ok(Map.of("message", "Aún no tienes reservas"));
        //}
        
        //List<ProviderReservationResource> reservationResources = reservations.stream()
          //      .map(ProviderReservationResourceFromEntityAssembler::toResourceFromEntity)
           //     .toList();
        
        //return ResponseEntity.ok(reservationResources);
    //}
}
