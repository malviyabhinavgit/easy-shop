package com.easy.shop.services;

import com.easy.shop.dto.CustomerDTO;
import com.easy.shop.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    void addCustomer(CustomerDTO customerDTO);
    Optional<Customer> getCustomer(String customerId);
    List<Customer> getCustomerByName(String customerName);
    List<Customer> getAllCustomers();
    void removeCustomer(String customerId);
}
