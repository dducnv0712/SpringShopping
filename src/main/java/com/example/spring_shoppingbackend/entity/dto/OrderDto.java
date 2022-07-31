package com.example.spring_shoppingbackend.entity.dto;


import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private BigDecimal totalPrice;
    private Set<OrderDetailsDto> orderDetails;
}
