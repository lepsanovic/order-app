package com.order_app.inventory_service.service.impl;

import com.order_app.inventory_service.exception.NotFoundException;
import com.order_app.inventory_service.model.dto.InventoryDto;
import com.order_app.inventory_service.model.entity.Inventory;
import com.order_app.inventory_service.repository.InventoryRepository;
import com.order_app.inventory_service.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    protected static final String PRODUCT_NOT_FOUND = "Product with sku code %s not found";

    private final InventoryRepository inventoryRepository;

    @Override
    public InventoryDto getProductQuantityInStock(String skuCode) {
        return InventoryDto.fromEntity(inventoryRepository.findBySkuCode(skuCode)
                .orElseThrow(() -> new NotFoundException(String.format(PRODUCT_NOT_FOUND, skuCode))));
    }

    @Override
    public List<InventoryDto> getProductsQuantityInStock(List<String> skuCodes) {
        List<Inventory> inventoryList = inventoryRepository.findBySkuCodeIn(skuCodes);

        return inventoryList.stream()
                .map(InventoryDto::fromEntity)
                .toList();
    }

    @Override
    public List<InventoryDto> getAllProductsInStock() {
        List<Inventory> inventoryList = inventoryRepository.findAll();

        return inventoryList.stream()
                .map(InventoryDto::fromEntity)
                .toList();
    }

}
