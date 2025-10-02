package com.consilium.consiliumbackend.auth.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.consilium.consiliumbackend.auth.requests.RegisterUserRequest;
import com.consilium.consiliumbackend.auth.responses.RegisterUserResponse;
import com.consilium.consiliumbackend.common.pojos.ApiResponse;

@Tag(name = "Authentication", description = "Endpoints for user authentication and registration")
public interface AuthController {
    @Operation(summary = "Register a new user",
            description = "Creates a new user account with the provided registration details.",
            operationId = "registerNewUser")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
                    description = "User registration successful",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiResponse.class),
                            examples = @ExampleObject(value = """
                                    {
                                      "status": "success",
                                      "message": "User registered successfully",
                                      "timestamp": "2025-10-02T19:21:00",
                                      "data": {
                                        "username": "johndoe123",
                                        "id": 1024
                                      },
                                      "errors": null
                                    }
                                    """)
                    )
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "400",
                    description = "Invalid input, validation failed",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiResponse.class),
                            examples = @ExampleObject(value = """
                                    {
                                      "status": "error",
                                      "message": "Validation failed for the request",
                                      "timestamp": "2025-10-02T19:21:00",
                                      "errors": [
                                        { "field": "username", "message": "Username must be between 6 and 64 characters long" },
                                        { "field": "password", "message": "Password must be between 8 and 16 characters" },
                                        { "field": "email", "message": "Email should be valid" },
                                        { "field": "firstName", "message": "First Name cannot be blank" }
                                      ],
                                      "data": null
                                    }
                                    """)
                    )
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiResponse.class),
                            examples = @ExampleObject(value = """
                                    {
                                      "status": "error",
                                      "message": "Unexpected error occurred",
                                      "timestamp": "2025-10-02T19:21:00",
                                      "errors": null,
                                      "data": null
                                    }
                                    """)
                    )
            )
    })
    ResponseEntity<ApiResponse<RegisterUserResponse>> registerNewUser(@Valid @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Registration details", required = true,
            content = @Content(schema = @Schema(implementation = RegisterUserRequest.class))) @RequestBody RegisterUserRequest registerUserRequest);
}
