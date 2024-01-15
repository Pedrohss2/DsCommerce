package com.ph.dscommerce.services;

import com.ph.dscommerce.dto.ProductDTO;
import com.ph.dscommerce.entities.Product;
import com.ph.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {

        Product product1 = repository.findById(id).get();
        return new ProductDTO(product1);
    }
}
