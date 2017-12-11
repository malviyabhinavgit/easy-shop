package com.easy.shop.repository;

import com.easy.shop.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {
    void addCustomer(Customer customer);
    Optional<Customer> getCustomer(String customerId);
    List<Customer> getCustomerByName(String customerName);
    List<Customer> getAllCustomers();
    void removeCustomer(String customerId);
}
