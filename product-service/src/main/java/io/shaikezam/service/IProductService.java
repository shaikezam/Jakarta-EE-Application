package io.shaikezam.service;

import io.shaikezam.model.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<ProductDTO> getAllProducts();

    Optional<ProductDTO> getProduct(long productId);

    Optional<String> getProductName(long productId);

    void updateProduct(long productId, ProductDTO productDTO);

    void updateProductQuantity(long productId, int quantityToDecrease);

    void createNewProduct(ProductDTO productDTO);

    void deleteProduct(long productId);
}
