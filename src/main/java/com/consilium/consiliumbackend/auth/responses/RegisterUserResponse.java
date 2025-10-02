package com.consilium.consiliumbackend.auth.responses;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(description = "Response returned after successful user registration")
public class RegisterUserResponse {
    @Schema(
            description = "Registered username for the new account",
            example = "johndoe123"
    )
    private String username;
    @Schema(
            description = "Unique identifier of the newly registered user",
            example = "1024",
            type = "integer",
            format = "int64"
    )
    private long id;
}
