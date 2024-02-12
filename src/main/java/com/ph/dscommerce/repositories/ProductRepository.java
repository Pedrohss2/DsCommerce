package com.ph.dscommerce.repositories;

import com.ph.dscommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select * from tb_product where UPPER(name) like UPPER(%:name%) ", nativeQuery = true)
    public List<Product> findByName(@Param("name") String name);


}

