package io.shaikezam.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = ProductEntity.TABLE_NAME)
public class ProductEntity extends AbstractEntity {

    public final static String TABLE_NAME = "PRODUCTS";

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "name", nullable = false)
    private String text;

}
