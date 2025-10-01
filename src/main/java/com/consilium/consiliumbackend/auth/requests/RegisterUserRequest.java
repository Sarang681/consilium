package com.consilium.consiliumbackend.auth.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import com.consilium.consiliumbackend.common.annotations.Password;

@Data
public class RegisterUserRequest {
    @NotBlank(message = "Username cannot be blank")
    @Size(min = 6, max = 64, message = "Username must be between 6 and 64 characters long")
    private String username;
    @Password
    private String password;
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email should be valid")
    private String email;
    @NotBlank(message = "First Name cannot be blank")
    private String firstName;
    private String lastName;
}
