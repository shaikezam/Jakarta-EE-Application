package io.shaikezam.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = OrderProductsEntity.TABLE_NAME)
public class OrderProductsEntity extends AbstractEntity {

    public final static String TABLE_NAME = "ORDER_PRODUCTS";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_id", nullable = false)
    private Long productId;
    @Column(name = "quantity", nullable = false)
    private Integer quantity;
}
