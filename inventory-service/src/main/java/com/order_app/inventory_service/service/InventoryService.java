package com.order_app.inventory_service.service;

import com.order_app.inventory_service.model.dto.InventoryDto;

import java.util.List;

public interface InventoryService {

    InventoryDto getProductQuantityInStock(String skuCode);

    List<InventoryDto> getProductsQuantityInStock(List<String> skuCodes);

    List<InventoryDto> getAllProductsInStock();
}
