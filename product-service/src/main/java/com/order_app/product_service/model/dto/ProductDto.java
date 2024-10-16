package com.order_app.product_service.model.dto;

import com.order_app.product_service.model.entity.Product;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private String skuCode;

    private String name;

    private String description;

    private Double price;

    public static ProductDto fromEntity(Product product) {
        return ProductDto.builder()
                .skuCode(product.getSkuCode())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

    public static Product toEntity(ProductDto productDto) {
        return Product.builder()
                .skuCode(productDto.getSkuCode())
                .name(productDto.getName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .build();
    }

}
