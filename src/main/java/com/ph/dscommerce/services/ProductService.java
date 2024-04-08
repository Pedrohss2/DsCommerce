package com.ph.dscommerce.services;

import com.ph.dscommerce.domain.entity.Product;
import com.ph.dscommerce.domain.repository.ProductRepository;
import com.ph.dscommerce.rest.dto.ProductDTO;
import com.ph.dscommerce.rest.dto.ProductMinDTO;
import com.ph.dscommerce.services.Exceptions.DatabaseException;
import com.ph.dscommerce.services.Exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Product product1 = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found."));
        return new ProductDTO(product1);
    }

    @Transactional(readOnly = true)
    public Page<ProductMinDTO> findAll(String name, Pageable pageable) {
        Page<Product> product = repository.searchByName(name, pageable);

        return product.map(x -> new ProductMinDTO(x));
    }

    @Transactional
    public ProductDTO insert(ProductDTO dto) {
        Product product = modelMapper.map(dto, Product.class);

        product = repository.save(product);

        return modelMapper.map(product, ProductDTO.class);
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO dto) {
        try {
            Product product = modelMapper.map(dto, Product.class);

            product = repository.save(product);

            return modelMapper.map(product, ProductDTO.class);
        }
        catch (EntityNotFoundException e) {
            throw  new ResourceNotFoundException("Resource not found.");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void deleteById(Long id) {
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found."));

        try {
            repository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("The deletion cannot be completed because a referential integrity failure has occurred");
        }
    }

    /* private void copyDtoToEntity(ProductDTO dto, Product product) {
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setImgUrl(dto.getImgUrl());

        product.getCategories().clear();

        for(CategoryDTO categoryDTO :  dto.getCategories()) {
            Category category = new Category();
            category.setId(categoryDTO.getId());
            product.getCategories().add(category);
        }
    } */

}
