package com.ph.dscommerce.rest.dto;

import com.ph.dscommerce.domain.entity.OrderItem;
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
    private String imgUrl;

    public OrderItemDTO(OrderItem orderItem) {
        productId = orderItem.getId().getProduct().getId();
        name = orderItem.getId().getProduct().getName();
        price = orderItem.getPrice();
        quantity = orderItem.getQuantity();
        imgUrl = orderItem.getId().getProduct().getImgUrl();
    }

    public Double getSubtotal() {
        return getPrice() * getQuantity();
    }

}
