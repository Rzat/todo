package com.example.todo.services;

import com.example.todo.domain.liquorMasterDomain.DailyPurchase;

import java.util.List;

public interface DailyPurchaseService {


    List<DailyPurchase> findAll();

    void newSaveDailyPurchase(DailyPurchase purchase) throws Exception;
}
