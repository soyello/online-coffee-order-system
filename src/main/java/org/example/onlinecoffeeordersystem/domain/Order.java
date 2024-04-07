package org.example.onlinecoffeeordersystem.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

@Getter
@Table(name = "orders")
public class Order {
    @Id
    private int orderId;
    @Column
    private int customerId;
    @Column
    private Timestamp orderAt;
    @MappedCollection(idColumn = "order_id",keyColumn = "order_item_id")
    private Set<OrderItem> orderItemList = new HashSet<>();

    public Order(int customerId,
                 Set<OrderItem> orderItemList){
        this.customerId = customerId;
        this.orderAt = Timestamp.valueOf(LocalDateTime.now());
        this.orderItemList = orderItemList;
    }

    public static Order newOrder(CreateOrder createOrder){
        Set<OrderItem> orderItemList = new HashSet<>();
        for(Map.Entry<Integer,Integer> entry: createOrder.getQuantityByProduct().entrySet()){
            orderItemList.add(new OrderItem(entry.getKey(), entry.getValue()));
        }

        return new Order(createOrder.getCustomerId(), orderItemList);
    }
}
