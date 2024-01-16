package com.ph.dscommerce.services;

import com.ph.dscommerce.dto.ProductDTO;
import com.ph.dscommerce.entities.Product;
import com.ph.dscommerce.repositories.ProductRepository;
import com.ph.dscommerce.services.exceptions.DatabaseException;
import com.ph.dscommerce.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
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

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Product product1 = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Resource not found")
        );

        return new ProductDTO(product1);

    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable) {
        Page<Product> product = repository.findAll(pageable);
        return product.map(x -> new ProductDTO(x));
    }

    @Transactional
    public ProductDTO insert(ProductDTO  productDTO) {
        Product product = new Product();

        copyDtoToEntity(productDTO, product);

         product = repository.save(product);

         return new ProductDTO(product);
    }


    public ProductDTO update(Long id, ProductDTO productDTO) {
        try {
            Product product = repository.getReferenceById(id);
            copyDtoToEntity(productDTO, product);
            product = repository.save(product);

            return new ProductDTO(product);
        }
        catch (EntityNotFoundException error) {
            throw new ResourceNotFoundException("Resource not found.");
        }

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {

        if(!repository.existsById(id)) {
            throw new ResourceNotFoundException("Resource not found.");
        }

        try {
            repository.deleteById(id);
        }
        catch (DataIntegrityViolationException error) {
            throw new DatabaseException("Falha de integridade referencial, deleção não pode ser feita");
        }
    }

    private void copyDtoToEntity(ProductDTO productDTO, Product product) {
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setImgUrl(productDTO.getImgUrl());
    }


}
