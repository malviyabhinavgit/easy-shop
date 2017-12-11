package com.easy.shop.controllers;

import com.easy.shop.entities.Customer;
import com.easy.shop.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Customer")
public class CustomerController {

    private  final CustomerService  customerService;

    CustomerController (CustomerService customerService){
     this.customerService = customerService;
    }

    @RequestMapping(path="{customerName}/{customerAddress}" ,method = RequestMethod.POST)
    public String addCustomer(@PathVariable String customerName,
                           @PathVariable String customerAddress) {
        this.customerService.addCustomer(customerName,customerAddress);
                return "Customer successfully added";
    }

    @RequestMapping(path="{customerId}",method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable String customerId) {
       return this.customerService.getCustomer(customerId).orElse(null);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> getCustomerByName(@RequestParam(value="customerName") String customerName) {
        return this.customerService.getCustomerByName(customerName);

    }
    @RequestMapping(path="/All",method = RequestMethod.GET)
    public List<Customer> getAllCustomer() {
        return this.customerService.getAllCustomers();

    }
    @RequestMapping(method = RequestMethod.DELETE)
    public String deleteCustomer(@RequestParam(value="customerId")String customerId) {
        this.customerService.removeCustomer(customerId);
        return "customer with :"+customerId+ "  was removed from our record.";

    }

}
