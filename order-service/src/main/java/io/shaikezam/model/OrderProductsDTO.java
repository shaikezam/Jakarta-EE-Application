package io.shaikezam.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderProductsDTO {
    private Long id;
    private Long productId;
    private String productName;
    private Integer quantity;
}

