package com.moveo.api.iam.interfaces.rest;

import com.moveo.api.iam.domain.model.aggregate.User;
import com.moveo.api.iam.domain.model.queries.GetUserByIdQuery;
import com.moveo.api.iam.domain.services.UserCommandService;
import com.moveo.api.iam.domain.services.UserQueryService;
import com.moveo.api.iam.interfaces.rest.resources.CreateUserResource;
import com.moveo.api.iam.interfaces.rest.resources.UserResource;
import com.moveo.api.iam.interfaces.rest.transform.CreateUserCommandFromResourceAssembler;
import com.moveo.api.iam.interfaces.rest.transform.UserResourceFromEntityAssembler;
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
@RequestMapping(value = "/api/v1/user", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "User", description = "Endpoints for Users")

public class UserController {
    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;

    public UserController(UserCommandService userCommandService, UserQueryService userQueryService) {
        this.userCommandService = userCommandService;
        this.userQueryService = userQueryService;
    }

    @PostMapping
    @Operation(
            summary = "Create a User",
            description = "Creates a user with the provided user atributes"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "User created"),
                    @ApiResponse(responseCode = "400", description = "Bad request")
            }
    )

    public ResponseEntity<UserResource> createUser(@RequestBody CreateUserResource resource)
    {
        var createUserCommand = CreateUserCommandFromResourceAssembler.toCommandFromResource(resource);
        Optional<User> user = userCommandService.handle(createUserCommand);
        return user.map(
                source -> new ResponseEntity<>(UserResourceFromEntityAssembler.toResourceFromEntity(source), CREATED)
        ).orElseGet(() -> ResponseEntity.badRequest().build());
    }
    @GetMapping("{id}?id2=123")
    @Operation(
            summary = "Get a User by ID",
            description = "Gets a user with ID param"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "User found"),
                    @ApiResponse(responseCode = "404", description = "Not found")
            }
    )
    public ResponseEntity<UserResource> getUserById(@PathVariable("id") Long id) {
        Optional<User> user = userQueryService.handle(new GetUserByIdQuery(id));
        return user.map(
                source -> ResponseEntity.ok(UserResourceFromEntityAssembler.toResourceFromEntity(source))
        ).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
