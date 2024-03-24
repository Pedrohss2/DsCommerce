package com.ph.dscommerce.rest.dto.errors;


import lombok.*;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomError {
    private Instant timestamp;
    private Integer status;
    private String error;

}
