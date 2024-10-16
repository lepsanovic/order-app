package com.order_app.order_service.model.enums;

public enum OrderStatus {
    SHIPPED("SHIPPED"),

    COMPLETED("COMPLETED"),

    DECLINED("DECLINED");

    private final String name;

    OrderStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
