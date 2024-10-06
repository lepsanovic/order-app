package com.order_app.product_service.service.impl;

import com.order_app.product_service.exception.NotFoundException;
import com.order_app.product_service.model.dto.ProductDto;
import com.order_app.product_service.model.entity.Product;
import com.order_app.product_service.repository.ProductRepository;
import com.order_app.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.order_app.product_service.model.dto.ProductDto.fromEntity;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    protected static final String PRODUCT_NOT_FOUND = "Product with sku code %s not found";

    private final ProductRepository productRepository;

    @Override
    public ProductDto create(ProductDto product) {
        return fromEntity(productRepository.save(ProductDto.toEntity(product)));
    }

    @Override
    public ProductDto getProduct(String skuCode) {
        return fromEntity(productRepository.findBySkuCode(skuCode)
                .orElseThrow(() -> new NotFoundException(String.format(PRODUCT_NOT_FOUND, skuCode))));
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(ProductDto::fromEntity)
                .toList();
    }

}
