package io.shaikezam.mapper;

import io.shaikezam.model.ProductDTO;
import io.shaikezam.persistence.entity.ProductEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface IProductMapper {

    ProductDTO productEntityToProductDTO(ProductEntity productEntity);

    ProductEntity productDTOToProductEntity(ProductDTO productDTO);

    List<ProductDTO> entitiesToDTOS(List<ProductEntity> entities);

    List<ProductEntity> DTOSToEntities(List<ProductDTO> dtos);
}
