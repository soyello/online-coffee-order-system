package org.example.onlinecoffeeordersystem.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Table(name = "store_products")
@Builder
public class StoreProduct {
    @Id
    private int storeProductId;
    @Column
    private int storeId;
    @Column
    private int productId;
    @Column
    private int stockQuantity;

    public void adjustStockQuantity(int buyQuantity){
        if(stockQuantity<buyQuantity){
            throw new RuntimeException("주문수량이 재고를 초과합니다.");
        }
        this.stockQuantity = this.stockQuantity - buyQuantity;
    }
}
