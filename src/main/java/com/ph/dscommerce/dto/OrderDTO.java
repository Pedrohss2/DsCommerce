package com.ph.dscommerce.dto;

import com.ph.dscommerce.dto.user.UserMinDTO;
import com.ph.dscommerce.entities.Order;
import com.ph.dscommerce.entities.OrderItem;
import com.ph.dscommerce.entities.enums.OrderStatus;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private Long id;
    private Instant moment;
    private OrderStatus status;
    private UserMinDTO user;
    private PaymentDTO payment;
    @NotEmpty(message = "field 'item' cannot be empty")
    private List<OrderItemDTO> items = new ArrayList<>();


    public OrderDTO(Order order) {
        id = order.getId();
        moment = order.getMoment();
        status = order.getStatus();
        user = new UserMinDTO(order.getUser());
        payment = (order.getPayment() == null) ? null : new PaymentDTO(order.getPayment());
        for(OrderItem item : order.getOrderItems()) {
            items.add(new OrderItemDTO(item));
        }
    }

    public Double getTotal() {
        double sum = 0.0;
        for(OrderItemDTO item : items) {
            sum +=  item.getSubtotal();
        }
        return sum;
    }


}
