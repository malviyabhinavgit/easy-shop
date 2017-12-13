package com.easy.shop.services;

import com.easy.shop.entities.Customer;
import com.easy.shop.entities.Product;
import com.easy.shop.entities.Visit;
import org.joda.time.DateTime;

import java.util.List;

public interface VisitService {
    void registerVisit(Customer customer, List<Product> purchase, DateTime visitDateBillTimong);
    List<Visit> getAllVisit();
    List<Visit> getBetweenDates(DateTime fromDate, DateTime toDate);
}
