package com.example.todo.services.daily;

import com.example.todo.domain.liquorMasterDomain.daily.SaveDailySale;

import java.util.List;

public interface DailySaleService {
    void saveDailySale(List<SaveDailySale> dailySale);
}
