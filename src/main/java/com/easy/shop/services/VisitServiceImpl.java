package com.easy.shop.services;

import com.easy.shop.entities.Visit;
import com.easy.shop.repository.VisitRepository;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public void registerVisit(Visit visit){
        this.visitRepository.registerVisit(visit);
    }
    @Override
    public List<Visit> getAllVisit(){
        return this.visitRepository.getAllVisit();
    }
    @Override
    public List<Visit> getBetweenDates(DateTime fromDate, DateTime toDate){
        return this.visitRepository.getAllVisit().parallelStream().filter(v->(fromDate.compareTo(v.getVisitDateBillTimong()) *
                toDate.compareTo(v.getVisitDateBillTimong()) >= 0)).collect(Collectors.toList());
    }

    private Visit assignVisitId(Visit visit) {
        visit.setVisitId("V"+counter);
        counter = counter+1;
        return visit;
    }
}
