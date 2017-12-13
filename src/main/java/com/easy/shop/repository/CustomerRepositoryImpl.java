package com.easy.shop.repository;

import com.easy.shop.entities.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private static final Logger log = LoggerFactory.getLogger(CustomerRepositoryImpl.class);

    private List<Customer> customers = new ArrayList<>();
    @Override
    public void addCustomer(final Customer customer){
        log.info("addCustomer {}",customer);
        customers.add(customer);
    }
    @Override
    public Optional<Customer>  getCustomer(String customerId){
        log.info("getCustomer {}",customerId);
        return customers.parallelStream().filter(customer -> customer.getCustomerId().equals(customerId)).findFirst();
    }
    @Override
    public List<Customer> getCustomerByName(final String customerName){
        log.info("getCustomerByName {}",customerName);
        return customers.parallelStream().filter(c->customerName.equals(c.getCustomerName())).collect(Collectors.toList());
    }
    @Override
    public List<Customer> getAllCustomers(){
        return customers;
    }
    @Override
    public void removeCustomer(final String customerId){
        log.info("removeCustomer {}",customerId);
        customers = customers.parallelStream().filter(c->c.getCustomerId().equals(customerId)==false).collect(Collectors.toList());
}

}
