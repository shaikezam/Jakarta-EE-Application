package io.shaikezam.mapper;

import io.shaikezam.model.OrderDTO;
import io.shaikezam.persistence.entity.OrderEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface IOrderMapper {

    OrderDTO orderEntityToOrderDTO(OrderEntity orderEntity);

    OrderEntity orderDTOToOrderEntity(OrderDTO orderDTO);

    List<OrderDTO> entitiesToDTOS(List<OrderEntity> entities);

    List<OrderEntity> DTOSToEntities(List<OrderDTO> dtos);
}
