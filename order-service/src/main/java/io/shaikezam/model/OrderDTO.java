package io.shaikezam.model;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO extends AbstractDTO {
    private Double price;
    private Long userId;
    private Set<OrderProductsDTO> orderProducts = new HashSet<>();
}
