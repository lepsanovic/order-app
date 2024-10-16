package com.order_app.order_service.proxy;

import com.order_app.order_service.model.dto.InventoryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "inventory", url = "localhost:7100/api/inventory")
@FeignClient(name= "inventory")
public interface InventoryProxy {

    @GetMapping("api/inventory/{skuCode}")
    public ResponseEntity<InventoryDto> getProductQuantityInStock(@PathVariable String skuCode);

}
