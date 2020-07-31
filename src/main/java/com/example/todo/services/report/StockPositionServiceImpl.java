package com.example.todo.services.report;

import com.example.todo.domain.liquorMasterDomain.daily.SaveDailySale;
import com.example.todo.repositories.daily.SaveDailySaleRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Slf4j
public class StockPositionServiceImpl implements StockPositionService {

    private final SaveDailySaleRepo saveDailySaleRepo;

    @Override
    public SaveDailySale findByShopNameAndDate(String shopName, LocalDate date) {
        System.out.println("Shop Name::" + shopName + "Local date is::" + date);
        System.out.println("findByShopNameAndDate:: " + saveDailySaleRepo.findAllByShopNameAndDate(shopName, date));


        return null;
    }
}
