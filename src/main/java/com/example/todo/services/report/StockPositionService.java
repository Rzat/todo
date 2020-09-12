package com.example.todo.services.report;

import java.time.LocalDate;
import java.util.List;

public interface StockPositionService {
    List findByShopName(String shopName, LocalDate date, String type, String packagingType);

    List findStockByCity(String cityName, LocalDate date, String type, String packagingType);

    List findByDistrict(String districtName, LocalDate localDate, String type, String packagingType);
}
