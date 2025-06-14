package com.moveo.api.test.payment.interfaces.rest;



import com.moveo.api.test.payment.domain.model.aggregate.Payment;
import com.moveo.api.test.payment.domain.model.queries.GetPaymentByIdQuery;
import com.moveo.api.test.payment.domain.services.PaymentCommandService;
import com.moveo.api.test.payment.domain.services.PaymentQueryService;
import com.moveo.api.test.payment.interfaces.rest.resources.CreatePaymentResource;
import com.moveo.api.test.payment.interfaces.rest.resources.PaymentResource;
import com.moveo.api.test.payment.interfaces.rest.transform.CreatePaymentCommandFromResourceAssembler;
import com.moveo.api.test.payment.interfaces.rest.transform.PaymentResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    private final PaymentCommandService paymentCommandService;
    private final PaymentQueryService paymentQueryService;


    public PaymentController(PaymentCommandService paymentCommandService, PaymentQueryService paymentQueryService) {
        this.paymentCommandService = paymentCommandService;
        this.paymentQueryService = paymentQueryService;
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
        return payment.map(
                source -> new ResponseEntity<>(PaymentResourceFromEntityAssembler.toResourceFromEntity(source), CREATED)
        ).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("{id}?id2=123")
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
        return payment.map(
                source -> ResponseEntity.ok(PaymentResourceFromEntityAssembler.toResourceFromEntity(source))
        ).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
