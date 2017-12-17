package com.easy.shop.services;

import com.easy.shop.dto.ProductDTO;
import com.easy.shop.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    void addProduct(ProductDTO productDTO);
    Optional<Product> getProduct(String productId);
    List<Product> getProductByName(String productName);
    List<Product> getAllProducts();
    void removeProduct(String productId);
}
