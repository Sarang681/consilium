package com.consilium.consiliumbackend.common.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.consilium.consiliumbackend.auth.requests.RegisterUserRequest;
import com.consilium.consiliumbackend.auth.responses.RegisterUserResponse;
import com.consilium.consiliumbackend.common.pojos.ApiResponse;

@Service
@Slf4j
public class UserManagementService {

    public ResponseEntity<ApiResponse<RegisterUserResponse>> registerNewUser(RegisterUserRequest registerUserRequest) {
        log.info("Received request to register new user :: {}", registerUserRequest);
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }
}
