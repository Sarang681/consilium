package com.consilium.consiliumbackend.common.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Error {
    private String key;
    private String message;
}
