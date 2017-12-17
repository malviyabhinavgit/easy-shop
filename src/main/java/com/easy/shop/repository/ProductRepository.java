package com.easy.shop.repository;

import com.easy.shop.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    void addProduct(Product product);
    Optional<Product> getProduct(String productId);
    List<Product> getProductByName(String productName);
    List<Product> getAllProducts();
    void removeProduct(String productId);
}
