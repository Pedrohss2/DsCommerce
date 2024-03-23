package com.ph.dscommerce.domain.entity.enums;

public enum OrderStatus {
    WAITING_PAYMENT("WAITING_PAYMENT"),
    PAID("PAID"),
    SHIPPED("SHIPPED"),
    DELIVERED("DELIVERED"),
    CANCELED("CANCELED");

    private String status;

    OrderStatus(String status) {

        this.status = status;
    }

}
