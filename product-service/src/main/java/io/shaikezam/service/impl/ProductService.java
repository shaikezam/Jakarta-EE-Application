package io.shaikezam.service.impl;

import io.shaikezam.mapper.IProductMapper;
import io.shaikezam.model.ProductDTO;
import io.shaikezam.persistence.entity.ProductEntity;
import io.shaikezam.persistence.repository.ProductEntityDao;
import io.shaikezam.service.IProductService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@ApplicationScoped
@RequiredArgsConstructor(onConstructor = @__({@Inject}))
public class ProductService implements IProductService {

    private final ProductEntityDao productEntityDao;
    private final IProductMapper productMapper;

    private static final Logger logger = Logger.getLogger(ProductService.class.getName());

    @Override
    public List<ProductDTO> getAllProducts() {
        List<ProductEntity> productEntities = productEntityDao.findAll();
        return productMapper.entitiesToDTOS(productEntities);
    }

    @Override
    public Optional<ProductDTO> getProduct(long productId) {
        ProductEntity productEntity = productEntityDao.findById(productId);
        return productEntity == null ? Optional.empty() : Optional.of(productMapper.productEntityToProductDTO(productEntity));
    }

    @Override
    public Optional<String> getProductName(long productId) {
        List<String> productNames = productEntityDao.findProductNameById(productId);
        return productNames.size() != 1 ? Optional.empty() : Optional.of(productNames.getFirst());
    }

    @Override
    public void updateProduct(long productId, ProductDTO productDTO) {
        ProductEntity productEntity = productEntityDao.findById(productId);
        productEntity.setPrice(productDTO.getPrice());
        productEntityDao.update(productEntity);
    }

    @Override
    public void createNewProduct(ProductDTO productDTO) {
        productEntityDao.create(productMapper.productDTOToProductEntity(productDTO));
    }

    @Override
    public void deleteProduct(long productId) {
        Optional<ProductDTO> optionalOrder = getProduct(productId);
        if (optionalOrder.isEmpty()) {
            return;
        }
        productEntityDao.delete(productEntityDao.findById(productId));
    }
}
