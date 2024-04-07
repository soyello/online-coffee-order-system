package org.example.onlinecoffeeordersystem.service;

import org.example.onlinecoffeeordersystem.domain.CreateOrder;
import org.example.onlinecoffeeordersystem.domain.StoreProduct;
import org.example.onlinecoffeeordersystem.repository.OrderRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {
    @Mock
    OrderRepository orderRepository;
    @Mock
    StoreService storeService;
    @InjectMocks
    OrderService orderService;

    @Test
    @DisplayName("구매 수량이 재고 수량보다 적을 때, 정상 주문이 가능하다.")
    public void stockQuantityTst_success(){
        //given
        int buyQuantity = 500;
        int stockQuantity = 50;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1,buyQuantity);
        CreateOrder createOrder = CreateOrder.builder()
                .storeId(1)
                .customerId(1)
                .quantityByProduct(map)
                .build();

        StoreProduct stock = StoreProduct.builder()
                .stockQuantity(stockQuantity)
                .build();

        when(storeService.getStoreProduct(1,1)).thenReturn(stock);

        //when
        orderService.newOrder(createOrder);

        //then
        assertThat(stock.getStockQuantity()).isEqualTo(stockQuantity-buyQuantity);

    }

    @Test
    @DisplayName("구매 수량이 재고보다 많으면, 정상 주문이 불가능하다.")
    public void stockQuantityTest_fail(){
        //given
        int buyQuantity = 500;
        int stockQuantity = 50;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1,buyQuantity);
        CreateOrder createOrder = CreateOrder.builder()
                .storeId(1)
                .customerId(1)
                .quantityByProduct(map)
                .build();

        StoreProduct stock = StoreProduct.builder()
                .stockQuantity(stockQuantity)
                .build();

        when(storeService.getStoreProduct(1,1)).thenReturn(stock);

        //when&then
        RuntimeException runtimeException = assertThrows(RuntimeException.class, ()->{
            orderService.newOrder(createOrder);
        });

        assertThat(runtimeException.getMessage()).isEqualTo("재고가 부족합니다.");
    }

}