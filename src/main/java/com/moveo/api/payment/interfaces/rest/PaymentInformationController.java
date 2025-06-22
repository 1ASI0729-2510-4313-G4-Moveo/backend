package com.moveo.api.payment.interfaces.rest;

import com.moveo.api.payment.domain.model.aggregate.PaymentInformation;
import com.moveo.api.payment.domain.model.queries.GetPaymentInformationByIdQuery;
import com.moveo.api.payment.domain.services.PaymentInformationCommandService;
import com.moveo.api.payment.domain.services.PaymentInformationQueryService;
import com.moveo.api.payment.interfaces.rest.resources.CreatePaymentInformationResource;
import com.moveo.api.payment.interfaces.rest.resources.PaymentInformationResource;
import com.moveo.api.payment.interfaces.rest.transform.CreatePaymentInformationCommandFromResourceAssembler;
import com.moveo.api.payment.interfaces.rest.transform.PaymentInformationResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
@RestController
@RequestMapping("/api/paymentInformation")
public class PaymentInformationController {
    private final PaymentInformationCommandService paymentInformationCommandService;
    private final PaymentInformationQueryService paymentInformationQueryService;


    public PaymentInformationController(PaymentInformationCommandService paymentInformationCommandService, PaymentInformationQueryService paymentInformationQueryService){
        this.paymentInformationCommandService = paymentInformationCommandService;
        this.paymentInformationQueryService = paymentInformationQueryService;

    }

    @PostMapping
    @Operation(
            summary = "Add Payment Information",
            description = "Add a payment with the given information "
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Payment Information added"),
                    @ApiResponse(responseCode = "400", description = "Bad request")
            }
    )
    public ResponseEntity<PaymentInformationResource> createPaymentInformation(@RequestBody CreatePaymentInformationResource resource)
    {
        var createPaymentInformationCommand = CreatePaymentInformationCommandFromResourceAssembler.toCommandFromResource(resource);
        Optional<PaymentInformation> paymentInformation = paymentInformationCommandService.handle(createPaymentInformationCommand);
        return paymentInformation.map(
                source -> new ResponseEntity<>(PaymentInformationResourceFromEntityAssembler.toResourceFromEntity(source), CREATED)
        ).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("{id}?id2=123")
    @Operation(
            summary = "Get a Payment Information by ID",
            description = "Gets a Payment Information with ID param"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Payment found"),
                    @ApiResponse(responseCode = "404", description = "Not found")
            }
    )
    public ResponseEntity<PaymentInformationResource> getPaymentInformationById(@PathVariable("id") Long id) {
        Optional<PaymentInformation> paymentInformation = paymentInformationQueryService.handle(new GetPaymentInformationByIdQuery(id));
        return paymentInformation.map(
                source -> ResponseEntity.ok(PaymentInformationResourceFromEntityAssembler.toResourceFromEntity(source))
        ).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
