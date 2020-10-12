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
public class SaleReportServiceImpl implements SaleReportService {

    private final SaveDailySaleRepo saveDailySaleRepo;
    private final StockPositionServiceImpl stockPosition;
    String identifier = "Sales_Report";

    @Override
    public List findByShopName(String shopName, LocalDate from, LocalDate to, String type, String packagingType, String identifier) {
        List<SaveDailySale> dailySale = saveDailySaleRepo.getAllShopBetweenDates(shopName, from, to);
        List<SaveDailySale> returnShopList = new ArrayList<>();
        stockPosition.getBySaveDailySale(type, packagingType, dailySale, returnShopList, identifier);
        return returnShopList;
    }

    @Override
    public List findByCityName(String cityName, LocalDate from, LocalDate to, String type, String packagingType) {
        List<SaveDailySale> dailySales = saveDailySaleRepo.getAllCityBetweenDates(cityName, from, to);
        List<SaveDailySale> returnShopList = new ArrayList<>();
        stockPosition.getBySaveDailySale(type, packagingType, dailySales, returnShopList, identifier);
        return returnShopList;
    }

    @Override
    public List findByDistrictName(String districtName, LocalDate from, LocalDate to, String type, String packagingType) {
        List<SaveDailySale> dailySales = saveDailySaleRepo.getAllDistrictBetweenDates(districtName, from, to);
        List<SaveDailySale> returnShopList = new ArrayList<>();
        stockPosition.getBySaveDailySale(type, packagingType, dailySales, returnShopList, identifier);
        return returnShopList;
    }
}
