package com.order_app.api_gateway.api_gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/get")
                        .filters(f -> f
                                .addRequestHeader("MyHeader", "MyURI")
                                .addRequestParameter("Param", "MyValue"))
                        .uri("http://httpbin.org:80"))
                .route(p -> p.path("/api/order/**")
                        .uri("lb://order"))
                .route(p -> p.path("/api/inventory/**")
                        .uri("lb://inventory"))
                .build();
    }
}

// instead of calling
// http://localhost:8765/order/api/order/product-quantity/SKU002
// call http://localhost:8765/api/order/product-quantity/SKU002