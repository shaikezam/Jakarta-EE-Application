package io.shaikezam.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;


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

}
