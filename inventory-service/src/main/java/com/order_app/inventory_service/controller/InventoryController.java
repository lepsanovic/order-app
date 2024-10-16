package com.order_app.inventory_service.controller;

import com.order_app.inventory_service.model.dto.InventoryDto;
import com.order_app.inventory_service.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    public ResponseEntity<List<InventoryDto>> getAllProductsInStock() {
        return new ResponseEntity<>(inventoryService.getAllProductsInStock(), HttpStatus.OK);
    }

    @GetMapping("{skuCode}")
    public ResponseEntity<InventoryDto> getProductQuantityInStock(@PathVariable String skuCode) {
        return new ResponseEntity<>(inventoryService.getProductQuantityInStock(skuCode), HttpStatus.OK);
    }

    @GetMapping("/by-sku-codes")
    public ResponseEntity<List<InventoryDto>> getProductsInStock(@RequestParam List<String> skuCodes) {
        return new ResponseEntity<>(inventoryService.getProductsQuantityInStock(skuCodes), HttpStatus.OK);
    }
}
