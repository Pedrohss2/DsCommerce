package com.ph.dscommerce.domain.repository;

import com.ph.dscommerce.domain.entity.OrdemItemPK;
import com.ph.dscommerce.domain.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrdemItemPK> {
}
