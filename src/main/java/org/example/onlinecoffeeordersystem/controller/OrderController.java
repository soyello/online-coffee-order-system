package org.example.onlinecoffeeordersystem.controller;

import org.example.onlinecoffeeordersystem.domain.CreateOrder;
import org.example.onlinecoffeeordersystem.domain.NewOrderRequest;
import org.example.onlinecoffeeordersystem.exception.Response;
import org.example.onlinecoffeeordersystem.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class OrderController {
    private final OrderService orderService;
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping("/api/v2/orders")
    public Response<Void> newOrder(@RequestBody NewOrderRequest request){
        orderService.newOrder(CreateOrder.builder()
                .customerId(request.getCustomerId())
                .storeId(request.getStoreId())
                .quantityByProduct(request.getProducts())
                .build());
        return Response.success(null);
    };
}
