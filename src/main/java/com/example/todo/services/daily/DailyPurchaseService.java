package com.example.todo.services.daily;

import com.example.todo.domain.liquorMasterDomain.daily.DailyPurchase;

import java.util.List;

public interface DailyPurchaseService {


    List<DailyPurchase> findAll();

    void newSaveDailyPurchase(DailyPurchase purchase) throws Exception;
}
