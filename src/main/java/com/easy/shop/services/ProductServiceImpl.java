package com.easy.shop.services;

import com.easy.shop.dto.ProductDTO;
import com.easy.shop.entities.Product;
import com.easy.shop.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    public void addProduct(final ProductDTO productDTO){

        log.info("addProduct {},{},{},{},{},",productDTO.getProductName(),productDTO.getProductCategory(),productDTO.getDateOfComingIntoEasyShop(),
                productDTO.getDateOfExpriy(),productDTO.getDateOfMFG());

        Product product = new Product(assignProductId(),productDTO.getProductName(),productDTO.getProductCategory(),
                productDTO.getDateOfComingIntoEasyShop(),null, productDTO.getDateOfExpriy(),
                productDTO.getDateOfMFG());

        this.productRepository.addProduct(product);
    }

    @Override
    public Optional<Product> getProduct(final String productId){
        log.info("getProduct {}",productId);
        return this.productRepository.getProduct(productId);
    }

    @Override
    public List<Product> getProductByName(final String productName){
        log.info("getProductByName {}",productName);
        return this.productRepository.getProductByName(productName);
    }

    @Override
    public List<Product> getAllProducts(){
        log.info("getAllProducts {}");
        return this.productRepository.getAllProducts();
    }

    @Override
    public void removeProduct(final String productId){
        log.info("removeProduct {}",productId);
        this.productRepository.removeProduct(productId);
    }

    private String assignProductId() {
        return Long.toString(ByteBuffer.wrap(UUID.randomUUID().toString().getBytes()).getLong(), Character.MAX_RADIX);
    }
}
