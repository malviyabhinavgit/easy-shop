package com.easy.shop.services;

import com.easy.shop.entities.Customer;

public interface EmailService {
    void sendEmail(String message);

    void notifyCustomerEmail(Customer customer);
}
