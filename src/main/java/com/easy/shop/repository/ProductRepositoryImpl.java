package com.easy.shop.repository;

import com.easy.shop.entities.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepositoryImpl implements ProductRepository{

    private static final Logger log = LoggerFactory.getLogger(ProductRepositoryImpl.class);

    private List<Product> products = new ArrayList<>();
    @Override
    public void addProduct(Product product){
        products.add(product);
    }
    @Override
    public Product getProduct(String productId){
        return products.parallelStream().filter(p->productId.equals(p.getProductID())).findFirst().get();
    }
    @Override
    public List<Product> getProductByName(String productName){
       return products.parallelStream().filter(p->productName.equals(p.getProductName())).collect(Collectors.toList());
    }
    @Override
    public List<Product> getAllProducts(){
        return products;
    }
    @Override
    public void removeProduct(Product product){
        products = products.parallelStream().filter(p->product.equals(p)==false).collect(Collectors.toList());
    }
}
