package org.example.onlinecoffeeordersystem.repository;

import org.example.onlinecoffeeordersystem.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
