package com.easy.shop.services;

import com.easy.shop.entities.Product;
import com.easy.shop.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
    private static  long counter = 1000;

    private final ProductRepository productRepository;
    @Autowired
    ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @Override
    public void addProduct(Product product){
        this.productRepository.addProduct(assignProductIdId(product));
    }
    @Override
    public Product getProduct(String productId){
        return this.productRepository.getProduct(productId);
    }
    @Override
    public List<Product> getProductByName(String productName){
        return this.productRepository.getProductByName(productName);
    }
    @Override
    public List<Product> getAllProducts(){
        return this.productRepository.getAllProducts();
    }
    @Override
    public void removeProduct(Product product){
        this.productRepository.removeProduct(product);
    }

    private Product assignProductIdId(Product product) {
        product.setProductID("PROD"+counter);
        counter = counter+1;
        return product;
    }
}
