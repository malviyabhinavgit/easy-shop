package com.easy.shop.services;

import com.easy.shop.constants.ProductCategory;
import com.easy.shop.entities.Product;
import org.joda.time.DateTime;

import java.util.List;

public interface ProductService {
    void addProduct(String productName, ProductCategory productCategory, DateTime dateOfComingIntoEasyShop, DateTime dateOfSellFromEasyShop, DateTime dateOfExpriy, DateTime dateOfMFG);
    Product getProduct(String productId);
    List<Product> getProductByName(String productName);
    List<Product> getAllProducts();
    void removeProduct(Product product);
}
