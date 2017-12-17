package com.easy.shop.services;

import com.easy.shop.dto.CustomerDTO;
import com.easy.shop.entities.Customer;
import com.easy.shop.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements  CustomerService {
    private static final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);


    private final CustomerRepository customerRepository;

    @Autowired
    CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository= customerRepository;
    }

    @Override
    public void addCustomer(final CustomerDTO customerDTO){
        log.info("addCustomer {} ",customerDTO);
        Customer customer = new Customer(assignCustomerId(),customerDTO.getCustomerName(),customerDTO.getAge(),
                customerDTO.getCustomerAddressFirstLine(),customerDTO.getCustomerAddressSecondLine(),
                customerDTO.getCusotmerType(),customerDTO.getRegistrationDate());
        this.customerRepository.addCustomer(customer);
    }

    @Override
    public Optional<Customer>  getCustomer(final String customerId){
        log.info("getCustomer {}",customerId);
        return customerRepository.getCustomer(customerId);
    }

    @Override
    public List<Customer> getCustomerByName( final String customerName){
        log.info("getCustomerByName {}",customerName);
        return this.customerRepository.getCustomerByName(customerName);
    }

    @Override
    public List<Customer> getAllCustomers(){
        return this.customerRepository.getAllCustomers();
    }

    @Override
    public void removeCustomer(final String customerId){
        log.info("removeCustomer {}",customerId);
        this.customerRepository.removeCustomer(customerId);
    }

    private String assignCustomerId() {
        return Long.toString(ByteBuffer.wrap(UUID.randomUUID().toString().getBytes()).getLong(), Character.MAX_RADIX);

    }
}
