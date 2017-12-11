package com.easy.shop.repository;

import com.easy.shop.entities.Visit;

import java.util.List;

public interface VisitRepository {
    void registerVisit(Visit visit);
    List<Visit> getAllVisit();

}
