package com.order_app.inventory_service.model.dto;

import com.order_app.inventory_service.model.entity.Inventory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InventoryDto {

    private String skuCode;

    private Double quantityInStock;

    public static InventoryDto fromEntity(Inventory inventory) {
        return InventoryDto.builder()
                .skuCode(inventory.getSkuCode())
                .quantityInStock(inventory.getQuantityInStock())
                .build();
    }

    public static Inventory toEntity(InventoryDto inventoryDto) {
        return Inventory.builder()
                .skuCode(inventoryDto.getSkuCode())
                .quantityInStock(inventoryDto.getQuantityInStock())
                .build();
    }

}
