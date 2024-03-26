package io.shaikezam.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor()
@Entity(name = "ORDERS")
public class OrderEntity extends AbstractEntity {

    public static String TABLE_NAME = "ORDERS";

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "user_id", nullable = false)
    private Long userId;
}
