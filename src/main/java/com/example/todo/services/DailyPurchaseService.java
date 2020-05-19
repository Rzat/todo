package com.example.todo.services;

import com.example.todo.domain.liquorMasterDomain.DailyPurchase;

import java.util.List;

public interface DailyPurchaseService {

    void saveDailyPurchase(DailyPurchase purchase);

    List<DailyPurchase> findAll();

    void newSaveDailyPurchase(DailyPurchase purchase);
}
