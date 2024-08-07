package io.shaikezam.mapper;

import io.shaikezam.model.OrderDTO;
import io.shaikezam.model.OrderProductsDTO;
import io.shaikezam.persistence.entity.OrderEntity;
import io.shaikezam.persistence.entity.OrderProductsEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI, injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = OrderMapperHelper.class)
public interface IOrderMapper {

    OrderDTO orderEntityToOrderDTO(OrderEntity orderEntity);

    OrderEntity orderDTOToOrderEntity(OrderDTO orderDTO);

    List<OrderDTO> orderEntitiesToDTOS(List<OrderEntity> entities);

    @Mapping(source = "productId", target = "productName", qualifiedByName = "fetchProductName")
    OrderProductsDTO orderProductEntityToDTO(OrderProductsEntity entity);
}
