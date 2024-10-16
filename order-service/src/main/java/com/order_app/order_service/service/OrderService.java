package com.order_app.order_service.service;

import com.order_app.order_service.model.dto.OrderDto;

public interface OrderService {

    OrderDto getOrderById(Long id);

}
