package com.easy.shop.dto;

import com.easy.shop.constants.ProductCategory;
import org.joda.time.DateTime;


public class ProductDTO {

    private String productName;

    private ProductCategory productCategory;

    private  DateTime dateOfComingIntoEasyShop;

    private  DateTime  dateOfExpriy;

    private  DateTime  dateOfMFG;

    public ProductDTO(){}


    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public void setDateOfComingIntoEasyShop(DateTime dateOfComingIntoEasyShop) {
        this.dateOfComingIntoEasyShop = dateOfComingIntoEasyShop;
    }

    public void setDateOfExpriy(DateTime dateOfExpriy) {
        this.dateOfExpriy = dateOfExpriy;
    }

    public void setDateOfMFG(DateTime dateOfMFG) {
        this.dateOfMFG = dateOfMFG;
    }

    public String getProductName() {
        return productName;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public DateTime getDateOfComingIntoEasyShop() {
        return dateOfComingIntoEasyShop;
    }

    public DateTime getDateOfExpriy() {
        return dateOfExpriy;
    }

    public DateTime getDateOfMFG() {
        return dateOfMFG;
    }
}
