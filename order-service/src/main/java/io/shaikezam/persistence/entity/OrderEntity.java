package io.shaikezam.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = OrderEntity.TABLE_NAME)
public class OrderEntity extends AbstractEntity {

    public final static String TABLE_NAME = "ORDERS";
    @Column(name = "price", nullable = false)
    private Double price;
    @Column(name = "user_id", nullable = false)
    private Long userId;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private List<OrderProductsEntity> orderProducts = new ArrayList<>();

}
