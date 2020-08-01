package com.example.todo.services.report;

import com.example.todo.domain.liquorMasterDomain.daily.SaveDailySale;

import java.time.LocalDate;
import java.util.List;

public interface StockPositionService {
    List<SaveDailySale> findByShopNameAndDate(String shopName, LocalDate date, String type, String packagingType);
}
