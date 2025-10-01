package com.consilium.consiliumbackend.common.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.consilium.consiliumbackend.auth.requests.RegisterUserRequest;
import com.consilium.consiliumbackend.auth.responses.RegisterUserResponse;
import com.consilium.consiliumbackend.common.pojos.ApiResponse;

@Service
public class UserManagementService {

    public ResponseEntity<ApiResponse<RegisterUserResponse>> registerNewUser(RegisterUserRequest registerUserRequest) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }
}
