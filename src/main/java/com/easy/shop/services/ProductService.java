package com.easy.shop.services;

import com.easy.shop.entities.Product;

import java.util.List;

public interface ProductService {
    void addProduct(Product product);
    Product getProduct(String productId);
    List<Product> getProductByName(String productName);
    List<Product> getAllProducts();
    void removeProduct(Product product);
}
