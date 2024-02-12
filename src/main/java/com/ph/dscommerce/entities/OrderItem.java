package com.ph.dscommerce.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_order_item")
public class OrderItem {

    @EmbeddedId
    private OrdemItemPK id = new OrdemItemPK();
    private Integer quantity;
    private Double price;


    public OrderItem(Order order,Product product, Integer quantity, Double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }
}
