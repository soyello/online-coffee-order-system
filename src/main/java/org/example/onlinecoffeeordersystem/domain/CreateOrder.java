package org.example.onlinecoffeeordersystem.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
@Builder
public class CreateOrder {
    private final int customerId;
    private final int storeId;
    private Map<Integer, Integer> quantityByProduct;
}
