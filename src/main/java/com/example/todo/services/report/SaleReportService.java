package com.example.todo.services.report;

import java.time.LocalDate;
import java.util.List;

public interface SaleReportService {
    List findByShopName(String shopName, LocalDate from, LocalDate to, String type, String packagingType, String identifier);

    List findByCityName(String cityName, LocalDate from, LocalDate to, String type, String packagingType);

    List findByDistrictName(String districtName, LocalDate from, LocalDate to, String type, String packagingType);
}
