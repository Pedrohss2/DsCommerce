package com.ph.dscommerce.repositories;

import com.ph.dscommerce.entities.OrdemItemPK;
import com.ph.dscommerce.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrdemItemPK> {
}
