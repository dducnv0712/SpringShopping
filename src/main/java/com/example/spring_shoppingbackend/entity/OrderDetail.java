package com.example.spring_shoppingbackend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "order_details")
public class OrderDetail {
    @EmbeddedId
    private OrderDetailId id;
    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    @JsonBackReference
    private Order order;
    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    @JsonManagedReference
    private Product product;
    private Integer quantity;
    private BigDecimal unitPrice;
}
