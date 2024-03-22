package com.ph.dscommerce.services;

import com.ph.dscommerce.dto.OrderDTO;
import com.ph.dscommerce.entities.Order;
import com.ph.dscommerce.repositories.OrderRepository;
import com.ph.dscommerce.services.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Order order = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found."));
        return new OrderDTO(order);
    }



}
