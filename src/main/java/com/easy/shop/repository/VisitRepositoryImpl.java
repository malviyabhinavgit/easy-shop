package com.easy.shop.repository;

import com.easy.shop.entities.Visit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VisitRepositoryImpl implements VisitRepository {

    private static final Logger log = LoggerFactory.getLogger(VisitRepositoryImpl.class);

    private List<Visit> visits = new ArrayList<>();
    @Override
    public void registerVisit(final Visit visit){
        visits.add(visit);
    }
    @Override
    public List<Visit> getAllVisit(){
      return visits;
    }
}
