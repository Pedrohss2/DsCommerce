package com.ph.dscommerce.services;

import com.ph.dscommerce.rest.dto.OrderDTO;
import com.ph.dscommerce.rest.dto.OrderItemDTO;
import com.ph.dscommerce.domain.entity.Order;
import com.ph.dscommerce.domain.entity.OrderItem;
import com.ph.dscommerce.domain.entity.Product;
import com.ph.dscommerce.domain.entity.User;
import com.ph.dscommerce.domain.entity.enums.OrderStatus;
import com.ph.dscommerce.domain.repository.OrderItemRepository;
import com.ph.dscommerce.domain.repository.OrderRepository;
import com.ph.dscommerce.domain.repository.ProductRepository;
import com.ph.dscommerce.services.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;


@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private AuthService authService;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Order order = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found."));
        authService.validateSelf(order.getUser().getId());
        return new OrderDTO(order);
    }

    @Transactional
    public OrderDTO insert(OrderDTO dto) {
        Order order = new Order();

        order.setMoment(Instant.now());
        order.setStatus(OrderStatus.WAITING_PAYMENT);

        User user = authorizationService.authenticated();
        order.setUser(user);

        for(OrderItemDTO dtos : dto.getItems()) {
            Product product = productRepository.getReferenceById(dtos.getProductId());
            OrderItem orderItem = new OrderItem(order, product, dtos.getQuantity(), product.getPrice());
            order.getOrderItems().add(orderItem);
        }

        repository.save(order);
        orderItemRepository.saveAll(order.getOrderItems());
        return new OrderDTO(order);
    }


}
