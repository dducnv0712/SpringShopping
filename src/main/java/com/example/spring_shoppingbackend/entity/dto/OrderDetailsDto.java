package com.example.spring_shoppingbackend.entity.dto;

import com.example.spring_shoppingbackend.entity.Product;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsDto {
    private Product product;
    private int quantity;
    private BigDecimal unitPrice;
}
