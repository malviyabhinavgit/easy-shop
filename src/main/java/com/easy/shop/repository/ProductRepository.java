package com.easy.shop.repository;

import com.easy.shop.entities.Product;

import java.util.List;

public interface ProductRepository {
    void addProduct(Product product);
    Product getProduct(String productId);
    List<Product> getProductByName(String productName);
    List<Product> getAllProducts();
    void removeProduct(String productId);
}
