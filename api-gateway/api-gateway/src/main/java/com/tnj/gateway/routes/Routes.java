//package com.tnj.gateway.routes;
//
//import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.function.HandlerFunction;
//import org.springframework.web.servlet.function.RequestPredicate;
//import org.springframework.web.servlet.function.RouterFunction;
//import org.springframework.web.servlet.function.ServerResponse;
//
//@Configuration
//public class Routes {
//    @Bean
//    public RouterFunction<ServerResponse> productServiceRoute() {
//        return GatewayRouterFunctions.route("product_service")
//                .route(RequestPredicate.path("/api/product"), HandlerFunction.http("http://localhost:8080"))
//                .build();
//    }
//}

package com.tnj.gateway.routes;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Routes {

    @Bean
    public RouteLocator productServiceRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("product_service", r -> r
                        .path("/api/product/**")
                        .uri("http://localhost:8080"))
                .build();
    }

    @Bean
    public RouteLocator orderServiceRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("order_service", r -> r
                        .path("/api/order/**")
                        .uri("http://localhost:8081"))
                .build();
    }

    @Bean
    public RouteLocator inventoryServiceRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("inventory_service", r -> r
                        .path("/api/inventory/**")
                        .uri("http://localhost:8082"))
                .build();
    }
}
