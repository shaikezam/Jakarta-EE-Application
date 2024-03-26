package io.shaikezam.model;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO extends AbstractDTO {
    private Double price;
    private Long userId;
}
