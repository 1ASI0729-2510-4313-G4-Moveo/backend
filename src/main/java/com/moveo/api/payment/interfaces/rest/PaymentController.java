package com.moveo.api.payment.interfaces.rest;

import com.moveo.api.payment.domain.model.aggregate.Payment;
import com.moveo.api.payment.domain.model.queries.GetPaymentByIdQuery;
import com.moveo.api.payment.domain.services.PaymentCommandService;
import com.moveo.api.payment.domain.services.PaymentQueryService;
import com.moveo.api.payment.domain.services.PaymentInformationQueryService;
import com.moveo.api.payment.domain.model.queries.GetPaymentInformationByIdQuery;
import com.moveo.api.payment.interfaces.rest.resources.CreatePaymentResource;
import com.moveo.api.payment.interfaces.rest.resources.PaymentResource;
import com.moveo.api.payment.interfaces.rest.resources.PaymentInformationResource;
import com.moveo.api.payment.interfaces.rest.transform.CreatePaymentCommandFromResourceAssembler;
import com.moveo.api.payment.interfaces.rest.transform.PaymentResourceFromEntityAssembler;
import com.moveo.api.payment.interfaces.rest.transform.PaymentInformationResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/payments")
@Tag(name = "Payment", description = "Payment API")
public class PaymentController {
    private final PaymentCommandService paymentCommandService;
    private final PaymentQueryService paymentQueryService;
    private final PaymentInformationQueryService paymentInformationQueryService;


    public PaymentController(PaymentCommandService paymentCommandService, PaymentQueryService paymentQueryService, PaymentInformationQueryService paymentInformationQueryService) {
        this.paymentCommandService = paymentCommandService;
        this.paymentQueryService = paymentQueryService;
        this.paymentInformationQueryService = paymentInformationQueryService;
    }

    @PostMapping
    @Operation(
            summary = "Add a payment",
            description = "Add a payment with the given information "
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Payment added"),
                    @ApiResponse(responseCode = "400", description = "Bad request")
            }
    )
    public ResponseEntity<PaymentResource> createPayment(@RequestBody CreatePaymentResource resource)
    {
        var createPaymentCommand = CreatePaymentCommandFromResourceAssembler.toCommandFromResource(resource);
        Optional<Payment> payment = paymentCommandService.handle(createPaymentCommand);
        return payment.map(source -> {
            var paymentInfo = paymentInformationQueryService.handle(new GetPaymentInformationByIdQuery(source.getPaymentInformationId())).orElse(null);
            PaymentInformationResource paymentInfoResource = paymentInfo != null ? PaymentInformationResourceFromEntityAssembler.toResourceFromEntity(paymentInfo) : null;
            return new ResponseEntity<>(PaymentResourceFromEntityAssembler.toResourceFromEntity(source, paymentInfoResource), CREATED);
        }).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get a payment by ID",
            description = "Gets a payment with ID param"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Payment found"),
                    @ApiResponse(responseCode = "404", description = "Not found")
            }
    )
    public ResponseEntity<PaymentResource> getPaymentById(@PathVariable("id") Long id) {
        Optional<Payment> payment = paymentQueryService.handle(new GetPaymentByIdQuery(id));
        return payment.map(source -> {
            var paymentInfo = paymentInformationQueryService.handle(new GetPaymentInformationByIdQuery(source.getPaymentInformationId())).orElse(null);
            PaymentInformationResource paymentInfoResource = paymentInfo != null ? PaymentInformationResourceFromEntityAssembler.toResourceFromEntity(paymentInfo) : null;
            return ResponseEntity.ok(PaymentResourceFromEntityAssembler.toResourceFromEntity(source, paymentInfoResource));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
