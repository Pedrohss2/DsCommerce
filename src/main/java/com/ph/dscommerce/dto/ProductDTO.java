package com.ph.dscommerce.dto;

import com.ph.dscommerce.entities.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long id;

    @Size(min = 3, max = 80, message = "Name field must have between 3 and 80 characters")
    @NotBlank(message = "Name field cannot be empty/null")
    private String name;

    @Size(min = 10, message = "Description needs at least 10 characters")
    @NotBlank(message = "Field 'description' cannot be null")
    private String description;

    @Positive(message = "price' field cannot be negative")
    private Double price;
    private String imgUrl;


    public ProductDTO(Product product) {
        id = product.getId();
        name = product.getName();
        description = product.getDescription();
        price = product.getPrice();
        imgUrl = product.getImgUrl();
    }

}