package com.easy.shop.controllers;

import com.easy.shop.dto.CustomerDTO;
import com.easy.shop.entities.Customer;
import com.easy.shop.services.CustomerService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {


    private  final CustomerService  customerService;

    @Autowired
    CustomerController (CustomerService customerService){
     this.customerService = customerService;
    }

    @RequestMapping(path="register" ,method = RequestMethod.POST)
    @ApiOperation(value = "Creates a customer.", notes = "You have to provide a valid customer dto object")
    public ResponseEntity <String> addCustomer(
            @ApiParam(value = "Name of the customer.", required = true)
            @RequestBody CustomerDTO customerDTO) {
        if (isValidCustomerDTO(customerDTO)) {
            this.customerService.addCustomer(customerDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("created");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed");
        }


    }

    @RequestMapping(path="{customerId}",method = RequestMethod.GET)
    @ApiOperation(value = "Gives a Customer.", notes = "You have to provide a valid customer Id.")
    public ResponseEntity <Customer>  getCustomerById(
            @ApiParam(value = "The Id of the customer.", required = true)
            @PathVariable String customerId) {

        if (isValidValue(customerId)) {
            Customer customer = this.customerService.getCustomer(customerId).orElse(null);
            if(customer!=null)
                return ResponseEntity.status(HttpStatus.OK).body(customer);
            else
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customer);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }


    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Gives all the customers which has name as passed.", notes = "You have to provide a valid customer Name.")
    public ResponseEntity <List<Customer>> getCustomerByName(
            @ApiParam(value = "The Name of the customer.", required = true)
            @RequestParam(value="customerName") String customerName) {

        if (isValidValue(customerName)) {
            List<Customer> customers = this.customerService.getCustomerByName(customerName);
            if(customers.size()!=0)
                return ResponseEntity.status(HttpStatus.OK).body(customers);
            else
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customers);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

    }

    @RequestMapping(path="/All",method = RequestMethod.GET)
    @ApiOperation(value = "Gives all customers.")
    public ResponseEntity <List<Customer>> getAllCustomer() {

        List<Customer> customers = this.customerService.getAllCustomers();
        if(customers.size()!=0)
            return ResponseEntity.status(HttpStatus.OK).body(customers);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customers);

    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete a customer.", notes = "You have to provide a valid customer ID.")
    public ResponseEntity<String>  deleteCustomer(
            @ApiParam(value = "The Id of the customer.", required = true)
            @RequestParam(value="customerId")String customerId) {

        if (isValidValue(customerId)) {

            Customer customer = this.customerService.getCustomer(customerId).orElse(null);

            if (customer != null) {
                this.customerService.removeCustomer(customerId);
                return ResponseEntity.status(HttpStatus.OK).body(customer.toString() + "  was deleted.");
            } else
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customerId + "doesnot exist..");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    private boolean isValidCustomerDTO(CustomerDTO customerDTO){
        if(customerDTO!=null){
            return isValidValue(customerDTO.getCustomerName())&&
                    isValidValue(customerDTO.getCustomerAddressFirstLine())&&
                    isValidValue(customerDTO.getCustomerAddressSecondLine())&&
                    isValidValue(customerDTO.getCusotmerType().name())&&
                    isValidAge(customerDTO.getAge());
        }else{
            return false;
        }
    }

    private boolean isValidValue(String value){
        return value != null && !value.isEmpty();
    }

    private boolean isValidAge(int value){
        return value >0;
    }

}
