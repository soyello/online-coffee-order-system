package org.example.onlinecoffeeordersystem.service;

import org.example.onlinecoffeeordersystem.domain.StoreProduct;
import org.example.onlinecoffeeordersystem.repository.StoreProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService {
    private final StoreProductRepository storeProductRepository;
    public StoreService(StoreProductRepository storeProductRepository){
        this.storeProductRepository = storeProductRepository;
    }
    public StoreProduct getStoreProduct(int storeId, int productId){
        Optional<StoreProduct> storeProductOptional = storeProductRepository.findByStoreIdAndProductId(storeId,productId);
        if(storeProductOptional.isEmpty()){
            throw new RuntimeException("재고가 없습니다.");
        }
        return storeProductOptional.get();
    }
    public void saveAll(List<StoreProduct> storeProducts){
        storeProductRepository.saveAll(storeProducts);
    }
}
