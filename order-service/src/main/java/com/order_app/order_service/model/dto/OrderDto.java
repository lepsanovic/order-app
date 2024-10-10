package com.order_app.order_service.model.dto;

import com.order_app.order_service.model.entity.Order;
import com.order_app.order_service.model.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private Long id;

    private Double totalPrice;

    private LocalDateTime created;

    private OrderStatus orderStatus;

    private List<OrderItemDto> orderItemDtoList;

    public static OrderDto fromEntity(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .totalPrice(order.getTotalPrice())
                .created(order.getCreated())
                .orderStatus(order.getOrderStatus())
                .orderItemDtoList(order.getOrderItems()
                        .stream()
                        .map(OrderItemDto::fromEntity)
                        .toList())
                .build();
    }

}
