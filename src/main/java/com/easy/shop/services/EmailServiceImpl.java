package com.easy.shop.services;

import com.easy.shop.entities.Customer;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;

    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendEmail(String message) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(new String[]{"abhinavmalviya.nitrkl@gmail.com", "abhinavmalviya.nitr@gmail.com"});
        msg.setSubject("Testing from Spring Boot");
        msg.setText(message);
        javaMailSender.send(msg);

    }

    @Override
    public void notifyCustomerEmail(Customer customer) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setReplyTo("no-reply@gmail.com");
        msg.setTo(new String[]{customer.getCustomerEmailId()});
        msg.setCc("easyshopenterprise@gmail.com");
        msg.setSubject("You are now customer of Easy Shop. Have a happy shopping!");
        msg.setText("We are pleased to have you on-board with us.\n" + customer.sharedInfoWithCustomer());
        javaMailSender.send(msg);
    }
}
