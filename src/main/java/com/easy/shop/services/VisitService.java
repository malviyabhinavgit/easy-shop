package com.easy.shop.services;

import com.easy.shop.entities.Visit;
import org.joda.time.DateTime;

import java.util.List;

public interface VisitService {
    void registerVisit(Visit visit);
    List<Visit> getAllVisit();
    List<Visit> getBetweenDates(DateTime fromDate, DateTime toDate);
}
