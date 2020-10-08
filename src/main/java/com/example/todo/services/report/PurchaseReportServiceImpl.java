package com.example.todo.services.report;

import com.example.todo.domain.liquorMasterDomain.daily.SaveDailySale;
import com.example.todo.repositories.daily.SaveDailySaleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseReportServiceImpl implements PurchaseReportService {

    private final SaveDailySaleRepo saveDailySaleRepo;
    private final StockPositionServiceImpl stockPosition;

    @Override
    public List findByShopName(String shopName, LocalDate from, LocalDate to, String type, String packagingType) {
        List<SaveDailySale> dailySale = saveDailySaleRepo.getAllShopBetweenDates(shopName, from, to);
        List<SaveDailySale> returnShopList = new ArrayList<>();
        stockPosition.getBySaveDailySale(type, packagingType, dailySale, returnShopList);
        return returnShopList;
    }
}
