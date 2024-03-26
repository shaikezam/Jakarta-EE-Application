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

    IOrderMapper INSTANCE = Mappers.getMapper(IOrderMapper.class);

    OrderDTO entityToDTO(OrderEntity entity);

    OrderEntity DTOToEntity(OrderDTO dto);

    default List<OrderDTO> entitiesToDTOS(List<OrderEntity> entities) {
        return entities.stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    default List<OrderEntity> DTOSToEntities(List<OrderDTO> dtos) {
        return dtos.stream()
                .map(this::DTOToEntity)
                .collect(Collectors.toList());
    }
}
