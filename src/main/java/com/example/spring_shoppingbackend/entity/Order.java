package com.example.spring_shoppingbackend.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private BigDecimal totalPrice;
    @JoinColumn(name = "account_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;
    @JsonManagedReference
    @OneToMany(mappedBy = "order",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private Set<OrderDetail> orderDetails;
    private int status;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;


    public void calculateTotalPrice() {
        this.totalPrice = BigDecimal.ZERO;
        if(this.orderDetails != null && !this.orderDetails.isEmpty()) {
            for(OrderDetail orderDetail : orderDetails) {
                this.totalPrice = this.totalPrice.add(orderDetail.getUnitPrice().multiply(BigDecimal.valueOf(orderDetail.getQuantity())));
            }
        }
        this.totalPrice = totalPrice;
    }
}
