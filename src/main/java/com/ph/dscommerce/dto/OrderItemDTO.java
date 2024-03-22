package com.ph.dscommerce.dto;

import com.ph.dscommerce.entities.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDTO {

    private Long productId;
    private String name;
    private Double price;
    private Integer quantity;

    public OrderItemDTO(OrderItem orderItem) {
        productId = orderItem.getId().getProduct().getId();
        name = orderItem.getId().getProduct().getName();
        price = orderItem.getPrice();
        quantity = orderItem.getQuantity();
    }

    public Double getSubtotal() {
        return getPrice() * getQuantity();
    }

}
