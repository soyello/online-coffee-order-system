package org.example.onlinecoffeeordersystem.repository;

import org.example.onlinecoffeeordersystem.domain.StoreProduct;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StoreProductRepository extends CrudRepository<StoreProduct, Integer> {
    Optional<StoreProduct> findByStoreIdAndProductId(int store,int productId);
}
