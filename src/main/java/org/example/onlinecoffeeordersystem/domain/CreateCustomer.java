package org.example.onlinecoffeeordersystem.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.relational.core.mapping.Column;
@Getter
@Builder
public class CreateCustomer {
    private final String name;
    private final String address;
    private final String phoneNumber;
}
