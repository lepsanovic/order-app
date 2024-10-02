package com.order_app.product_service.service;

import com.order_app.product_service.model.dto.ProductDto;

public interface ProductService {

    ProductDto create(ProductDto product);
    ProductDto getProduct(String skuCode);

}
