package com.easy.shop.services;

import com.easy.shop.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Customer addCustomer(String customerName, String customerAddress, String emailAddress);
    Optional<Customer> getCustomer(String customerId);
    List<Customer> getCustomerByName(String customerName);
    List<Customer> getAllCustomers();
    void removeCustomer(String customerId);
}
