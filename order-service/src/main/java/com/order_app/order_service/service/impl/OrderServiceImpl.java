package com.order_app.order_service.service.impl;

import com.order_app.order_service.exception.NotFoundException;
import com.order_app.order_service.model.dto.OrderDto;
import com.order_app.order_service.repository.OrderRepository;
import com.order_app.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    protected static final String ORDER_NOT_FOUND = "Order with id %s not found";

    private final OrderRepository orderRepository;

    @Override
    public OrderDto getOrderById(Long id) {
        return OrderDto.fromEntity(orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format(ORDER_NOT_FOUND, id))));
    }

}
