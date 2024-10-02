package com.order_app.product_service.service.impl;

import com.order_app.product_service.model.dto.ProductDto;
import com.order_app.product_service.repository.ProductRepository;
import com.order_app.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductDto create(ProductDto product) {
        return ProductDto.fromEntity(productRepository.save(ProductDto.toEntity(product)));
    }

    @Override
    public ProductDto getProduct(String skuCode) {
        return ProductDto.fromEntity(productRepository.findBySkuCode(skuCode));
    }

}
