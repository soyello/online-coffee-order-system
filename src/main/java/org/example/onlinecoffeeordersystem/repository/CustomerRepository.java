package org.example.onlinecoffeeordersystem.repository;

import com.sun.jdi.IntegerType;
import org.example.onlinecoffeeordersystem.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
