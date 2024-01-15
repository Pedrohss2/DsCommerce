package com.ph.dscommerce.services;

import com.ph.dscommerce.dto.ProductDTO;
import com.ph.dscommerce.entities.Product;
import com.ph.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;
    public ProductDTO findById(Long id) {
        Optional<Product> product = repository.findById(id);
        Product product1 = product.get();
        ProductDTO dto = new ProductDTO(product1);

        return dto;
    }
}
