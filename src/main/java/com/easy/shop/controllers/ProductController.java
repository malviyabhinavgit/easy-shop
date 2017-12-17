package com.easy.shop.controllers;

import com.easy.shop.dto.ProductDTO;
import com.easy.shop.entities.Product;
import com.easy.shop.services.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private  final ProductService  productService;

    @Autowired
    ProductController (ProductService productService){
        this.productService = productService;
    }

    @RequestMapping(path="add" ,method = RequestMethod.POST)
    @ApiOperation(value = "Creates a product.", notes = "You have to provide a valid product dto.")
    public String addProduct(
            @ApiParam(value = "The product dto object.", required = true)
            @RequestBody ProductDTO productDTO) {
        this.productService.addProduct(productDTO);
        return "Customer successfully added";
    }

    @RequestMapping(path="{productId}",method = RequestMethod.GET)
    @ApiOperation(value = "Gives a product.", notes = "You have to provide a valid product id.")
    public Product getProductById(
            @ApiParam(value = "The id of the product.", required = true)
            @PathVariable String productId) {

        return this.productService.getProduct(productId).orElse(null);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Gives product or products.", notes = "You have to provide a valid product name.")
    public List<Product> getProductByName(
            @ApiParam(value = "The name of the product.", required = true)
            @RequestParam(value="productName") String productName) {

        return this.productService.getProductByName(productName);

    }

    @RequestMapping(path="/All",method = RequestMethod.GET)
    @ApiOperation(value = "Gives all products.")
    public List<Product> getAllCustomer() {

        return this.productService.getAllProducts();

    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ApiOperation(value = "Removes a product.", notes = "You have to provide a valid product id.")
    public String deleteCustomer(
            @ApiParam(value = "The id of the product.", required = true)
            @RequestParam(value="productId")String productId) {

        this.productService.removeProduct(productId);
        return "product with :"+productId+ "  was removed from our record.";

    }


}
