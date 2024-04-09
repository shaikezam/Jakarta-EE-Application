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

@Mapper(componentModel = MappingConstants.ComponentModel.CDI, injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = Temp.class)
public interface IOrderMapper {

    OrderDTO orderEntityToOrderDTO(OrderEntity orderEntity);

    OrderEntity orderDTOToOrderEntity(OrderDTO orderDTO);

    List<OrderDTO> orderEntitiesToDTOS(List<OrderEntity> entities);

    List<OrderEntity> ordersDTOSToEntities(List<OrderDTO> dtos);

    OrderDTO orderProductsEntityToOrderProductsDTO(OrderProductsEntity orderProductsEntity);

    OrderEntity orderProductsDTOToOrderEntityProducts(OrderProductsDTO orderProductsDTO);

    List<OrderProductsDTO> orderProductsEntitiesToDTOS(List<OrderProductsEntity> entities);

    @Mapping(source = "productId", target = "productName", qualifiedByName = "lol")
    OrderProductsDTO orderProductEntityToDTO(OrderProductsEntity entity);

    List<OrderProductsEntity> ordersProductsDTOSToEntities(List<OrderProductsDTO> dtos);
}
