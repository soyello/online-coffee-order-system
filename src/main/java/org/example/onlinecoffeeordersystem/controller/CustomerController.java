package org.example.onlinecoffeeordersystem.controller;

import org.example.onlinecoffeeordersystem.domain.CreateCustomer;
import org.example.onlinecoffeeordersystem.domain.Customer;
import org.example.onlinecoffeeordersystem.domain.CustomerDto;
import org.example.onlinecoffeeordersystem.exception.Response;
import org.example.onlinecoffeeordersystem.service.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    private final CustomerService customerService;
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping("/api/v1/customers")
    public Response<CustomerDto> createNewCustomer(
            @RequestParam String name,
            @RequestParam String address,
            @RequestParam String phoneNumber
    ){
        return Response.success(customerService.newCustomer(
                CreateCustomer.builder()
                        .address(address)
                        .name(name)
                        .phoneNumber(phoneNumber)
                        .build())
        );
    }
}
