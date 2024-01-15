package com.ph.dscommerce.controllers;

import com.ph.dscommerce.entities.Product;
import com.ph.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductRepository repository;


    @GetMapping
    public String teste() {
        Optional<Product> valores = repository.findById(1L);
        Product product = valores.get();
        return product.getName() + "  " + product.getId();
    }


}
