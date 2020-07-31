package com.example.todo.services.report;

import com.example.todo.domain.liquorMasterDomain.daily.SaveDailySale;

import java.time.LocalDate;

public interface StockPositionService {
    public SaveDailySale findByShopNameAndDate(String shopName, LocalDate date);
}
