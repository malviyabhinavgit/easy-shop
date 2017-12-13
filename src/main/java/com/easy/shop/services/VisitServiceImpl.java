package com.easy.shop.services;

import com.easy.shop.entities.Customer;
import com.easy.shop.entities.Product;
import com.easy.shop.entities.Visit;
import com.easy.shop.repository.VisitRepository;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class VisitServiceImpl implements VisitService{

    private static final Logger log = LoggerFactory.getLogger(VisitServiceImpl.class);
    private static  long counter = 1000;

    private final VisitRepository visitRepository;

    @Autowired
    VisitServiceImpl(VisitRepository visitRepository){
        this.visitRepository = visitRepository;
    }

    @Override
    public void registerVisit(Customer customer, List<Product> purchase, DateTime visitDateBillTimong){
        log.info("registerVisit {} {} {} ",customer,purchase,visitDateBillTimong);
        Visit visit = new Visit(assignVisitId(),customer, purchase,visitDateBillTimong);
        this.visitRepository.registerVisit(visit);
    }
    @Override
    public List<Visit> getAllVisit(){
        log.info("getAllVisit  ");
        return this.visitRepository.getAllVisit();
    }
    @Override
    public List<Visit> getBetweenDates(DateTime fromDate, DateTime toDate){
        log.info("getBetweenDates {},{}",fromDate,toDate);
        return this.visitRepository.getAllVisit().parallelStream().filter(v->(fromDate.compareTo(v.getVisitDateBillTimong()) *
                toDate.compareTo(v.getVisitDateBillTimong()) >= 0)).collect(Collectors.toList());
    }

    private String assignVisitId() {
        return Long.toString(ByteBuffer.wrap(UUID.randomUUID().toString().getBytes()).getLong(), Character.MAX_RADIX);
    }
}
