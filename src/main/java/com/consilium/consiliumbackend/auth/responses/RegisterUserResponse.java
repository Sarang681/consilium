package com.consilium.consiliumbackend.auth.responses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterUserResponse {
    private String username;
    private long id;
}
