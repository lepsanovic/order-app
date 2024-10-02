package com.order_app.product_service.repository;

import com.order_app.product_service.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findBySkuCode(String skuCode);

}
