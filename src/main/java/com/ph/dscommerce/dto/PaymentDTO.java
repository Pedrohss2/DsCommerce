package com.ph.dscommerce.dto;

import com.ph.dscommerce.entities.Payment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {

    private Long id;
    private Instant moment;

    public PaymentDTO(Payment payment) {
        id = payment.getId();
        moment = payment.getMoment();
    }

}
