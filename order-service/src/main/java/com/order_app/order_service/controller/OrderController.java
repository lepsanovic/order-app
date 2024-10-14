package com.order_app.order_service.controller;

import com.order_app.order_service.model.dto.InventoryDto;
import com.order_app.order_service.model.dto.OrderDto;
import com.order_app.order_service.proxy.InventoryProxy;
import com.order_app.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/order")
public class OrderController {

    private final OrderService orderService;

    private final InventoryProxy inventoryProxy;

    @GetMapping("{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Long id) {
        return new ResponseEntity<>(orderService.getOrderById(id), HttpStatus.OK);
    }

    @GetMapping("/product-quantity/{skuCode}")
    public ResponseEntity<InventoryDto> getProductQuantityInStock(@PathVariable String skuCode) {
       return inventoryProxy.getProductQuantityInStock(skuCode);
    }
}
