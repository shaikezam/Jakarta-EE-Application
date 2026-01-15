package io.shaikezam.model;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO extends AbstractDTO {
    private Double price;
    private String description;
    private String name;
    private int quantityAvailable;
    private boolean isAvailable;
}
