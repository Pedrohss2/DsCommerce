package com.ph.dscommerce.dto;

import com.ph.dscommerce.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductMinDTO {
    private Long id;

    private String name;

    private Double price;
    private String imgUrl;


    public ProductMinDTO(Product product) {
        id = product.getId();
        name = product.getName();
        price = product.getPrice();
        imgUrl = product.getImgUrl();
    }

}
