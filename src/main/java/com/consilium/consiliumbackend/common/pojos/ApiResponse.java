package com.consilium.consiliumbackend.common.pojos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ApiResponse<T> {
    private String message;
    private String status;
    private List<Error> errors;
    private LocalDateTime timestamp;
    private T data;
}
