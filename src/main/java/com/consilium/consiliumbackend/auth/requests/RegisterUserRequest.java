package com.consilium.consiliumbackend.auth.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import com.consilium.consiliumbackend.common.annotations.Password;

@Data
@Schema(description = "Register User request payload")
public class RegisterUserRequest {
    @NotBlank(message = "Username cannot be blank")
    @Size(min = 6, max = 64, message = "Username must be between 6 and 64 characters long")
    @Schema(
            description = "Username must be between 6 and 64 characters long and cannot be blank",
            example = "johndoe123",
            minLength = 6,
            maxLength = 64
    )
    private String username;
    @Password
    @Schema(
            description = """
                    Password must fulfill the following requirements:
                    • 8–16 characters
                    • At least 1 uppercase letter
                    • At least 1 lowercase letter
                    • At least 1 digit
                    • At least 1 special character
                    • Cannot contain a sequence of 5+ alphabetical, numerical, or QWERTY characters
                    • No whitespace allowed
                    • Cannot be blank""",
            example = "MyStr0ngP@ss!",
            minLength = 8,
            maxLength = 16,
            format = "password"
    )
    private String password;
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email should be valid")
    @Schema(
            description = "Valid email address of the user",
            example = "john.doe@example.com",
            format = "email"
    )
    private String email;
    @NotBlank(message = "First Name cannot be blank")
    @Schema(
            description = "User's first name (cannot be blank)",
            example = "John"
    )
    private String firstName;

    @Schema(
            description = "User's last name (optional)",
            example = "Doe",
            nullable = true
    )
    private String lastName;
}
