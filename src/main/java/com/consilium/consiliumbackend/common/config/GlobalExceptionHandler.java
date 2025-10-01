package com.consilium.consiliumbackend.common.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.consilium.consiliumbackend.common.pojos.ApiResponse;
import com.consilium.consiliumbackend.common.pojos.Error;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Object>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<Error> errors = new ArrayList<>();

        ex.getBindingResult().getFieldErrors().forEach((error) -> {
            String property = error.getField();
            String message = error.getDefaultMessage();
            errors.add(new Error(property, message));
        });

        ApiResponse<Object> result = ApiResponse
                .builder()
                .status("Failed")
                .message("Validation Failed")
                .errors(errors)
                .data(null)
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.badRequest().body(result);
    }

}
