package com.consilium.consiliumbackend.auth.controllers.impl;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consilium.consiliumbackend.auth.controllers.AuthController;
import com.consilium.consiliumbackend.auth.requests.RegisterUserRequest;
import com.consilium.consiliumbackend.common.pojos.ApiResponse;
import com.consilium.consiliumbackend.auth.responses.RegisterUserResponse;
import com.consilium.consiliumbackend.common.services.UserManagementService;
import com.consilium.consiliumbackend.common.utils.Constants;

@RestController
@RequestMapping(Constants.API_VERSION_V1 + "/auth")
public class AuthControllerImpl implements AuthController {

    private final UserManagementService userManagementService;

    public AuthControllerImpl(UserManagementService userManagementService) {
        this.userManagementService = userManagementService;
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<RegisterUserResponse>> registerNewUser(@Valid @RequestBody RegisterUserRequest registerUserRequest) {
        return userManagementService.registerNewUser(registerUserRequest);
    }

}
