package dev.vio.OrderService.service;

import dev.vio.OrderService.dto.OrderRequest;

public interface OrderService {

    String placeOrder(OrderRequest orderRequest);
}
